package com.xcloud.qixinspy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcloud.qixinspy.parser.AbilityParser;
import com.xcloud.qixinspy.parser.BasicParser;
import com.xcloud.qixinspy.parser.OperationParser;
import com.xcloud.qixinspy.parser.RiskParser;

@Controller
public class SpyController {

    @Autowired
    private SpyConfig spyConfig;
    @Autowired
    private BasicParser basicParser;
    @Autowired
    private RiskParser riskParser;
    @Autowired
    private AbilityParser abilityParser;
    @Autowired
    private OperationParser operationParser;

    @RequestMapping(value = "/spy.do/{company}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String spy(@PathVariable String company, @RequestBody String json) {
        WebDriver driver = null;
        try {
            System.setProperty("webdriver.chrome.driver", spyConfig.getDriverPath());
            // ChromeOptions options = new ChromeOptions();
            // options.setBinary(spyConfig.getBinPath());
            driver = new ChromeDriver();
            driver.get("http://www.qixin.com/");
            driver.manage().window().maximize();
            List<Cookie> list = CookieUtils.parse(json);
            for (Cookie e : list) {
                driver.manage().addCookie(e);
            }
            WebElement element = driver.findElement(By.id("searchBar"));
            element.sendKeys(company);
            element.submit();
            element = driver.findElement(By.linkText(company));
            String url = element.getAttribute("href");
            driver.get(url);
            // Set<String> allWindowsId = driver.getWindowHandles();
            // for (String windowId : allWindowsId) {
            // if
            // (driver.switchTo().window(windowId).getTitle().contains("工商信息"))
            // {
            // driver.switchTo().window(windowId);
            // break;
            // }
            // }
            String uuid = driver.findElement(By.xpath("//*[@id=\"eidHidden\"]")).getAttribute("value");
            String zjh = driver
                    .findElement(By.cssSelector(
                            "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(2) > td:nth-child(2)"))
                    .getText();
            StringBuffer sb = new StringBuffer();
            sb.append(basicParser.parseQy(uuid, driver));
            sb.append(basicParser.parseQygdxx(zjh, driver));
            sb.append(basicParser.parseQyzyry(zjh, driver));
            sb.append(basicParser.parseQyfzjg(zjh, driver));
            sb.append(riskParser.parse(zjh, driver));
            sb.append(abilityParser.parse(zjh, driver));
            sb.append(operationParser.parse(zjh, driver));
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}