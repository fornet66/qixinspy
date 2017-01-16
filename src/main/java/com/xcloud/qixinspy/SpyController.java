package com.xcloud.qixinspy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpyController {

    @Autowired
    private SpyConfig spyConfig;
    @Autowired
    private BasicInfoParser basicInfoParser;

    @RequestMapping(value = "/spy.do/{company}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String spy(@PathVariable String company, @RequestBody String json) {
        URL serverurl = null;
        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--user-agent=" + spyConfig.getUserAgent());
            // String bin = "/home/yjcloud/chromedriver";
            // options.setBinary(bin);
            // System.setProperty("webdriver.chrome.driver", bin);
            serverurl = new URL("http://127.0.0.1:9515");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new RemoteWebDriver(serverurl, capabilities);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            // driver = new ChromeDriver(options);
            driver.get("http://www.qixin.com/");
            driver.manage().window().maximize();
            List<Cookie> list = CookieParser.parse(json);
            for (Cookie e : list) {
                driver.manage().addCookie(e);
            }
            WebElement element = driver.findElement(By.id("searchBar"));
            element.sendKeys(company);
            element.submit();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            element = driver.findElement(By.linkText(company));
            element.click();
            Set<String> allWindowsId = driver.getWindowHandles();
            for (String windowId : allWindowsId) {
                if (driver.switchTo().window(windowId).getTitle().contains("联系方式")) {
                    driver.switchTo().window(windowId);
                    break;
                }
            }
            String uuid = driver.findElement(By.xpath("//*[@id=\"eidHidden\"]")).getAttribute("value");
            basicInfoParser.parse(uuid, company, driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
        return "ok";
    }

}