package com.xcloud.qixinspy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/xienan/Desktop/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("http://www.qixin.com/company/af31b877-ed94-4781-a8d2-af575ef2dcfc");
            String uuid = driver.findElement(By.xpath("//*[@id=\"eidHidden\"]")).getAttribute("value");
            WebElement element = driver.findElement(By.cssSelector("div.panel.panel-default.basic-info"));
            String zjh = element.findElement(By.xpath("//div/table/tbody/tr[2]/td[2]")).getText();
            String tyxydm = element.findElement(By.xpath("//div/table/tbody/tr[1]/td[2]")).getText();
            String zzjgdm = element.findElement(By.xpath("//div/table/tbody/tr[1]/td[4]")).getText();
            String zyzt = element.findElement(By.xpath("//div/table/tbody/tr[2]/td[4]")).getText();
            String gslx = element.findElement(By.xpath("//div/table/tbody/tr[3]/td[2]")).getText();
            System.out.println(uuid);
            System.out.println(zjh);
            System.out.println(tyxydm);
            System.out.println(zzjgdm);
            System.out.println(zyzt);
            System.out.println(gslx);
            BasicInfoParser parser = new BasicInfoParser();
            parser.parse(uuid, "杭州云嘉云计算有限公司", driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
