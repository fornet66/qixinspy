package com.xcloud.qixinspy;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xcloud.qixinspy.db.dao.QyDao;
import com.xcloud.qixinspy.db.model.QyVO;

@Transactional
public class BasicInfoParser {

    @Autowired
    private QyDao qyDao;

    public String parse(String uuid, String name, WebDriver driver) {
        WebElement element = driver.findElement(By.cssSelector("div.panel.panel-default.basic-info"));
        QyVO vo = new QyVO();
        vo.setUuid(uuid);
        vo.setQymc(name);
        vo.setZjh(element.findElement(By.xpath("//div/table/tbody/tr[2]/td[2]")).getText());
        vo.setTyshxydm(element.findElement(By.xpath("//div/table/tbody/tr[1]/td[2]")).getText());
        vo.setZzjgdm(element.findElement(By.xpath("//div/table/tbody/tr[1]/td[4]")).getText());
        vo.setJyzt(element.findElement(By.xpath("//div/div/table/tbody/tr[2]/td[4]")).getText());
        vo.setGslx(element.findElement(By.xpath("//div/div/table/tbody/tr[3]/td[2]")).getText());
        try {
            String date = element.findElement(By.xpath("//div/div/table/tbody/tr[3]/td[4]")).getText();
            vo.setClrq(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        vo.setFddbr(element.findElement(By.xpath("//div/div/table/tbody/tr[4]/td[2]/a[1]")).getText());
        vo.setYyqx(element.findElement(By.xpath("//div/div/table/tbody/tr[4]/td[4]")).getText());
        vo.setZczb(element.findElement(By.xpath("//div/div/table/tbody/tr[5]/td[2]")).getText());
        vo.setFzrq(element.findElement(By.xpath("//div/div/table/tbody/tr[5]/td[4]")).getText());
        vo.setDjjg(element.findElement(By.xpath("//div/div/table/tbody/tr[6]/td[2]")).getText());
        vo.setQydz(element.findElement(By.xpath("//div/div/table/tbody/tr[7]/td[2]")).getText());
        vo.setJyfw(element.findElement(By.xpath("//div/div/table/tbody/tr[8]/td[2]")).getText());
        qyDao.deleteById(vo);
        qyDao.insert(vo);
        return vo.toString();
    }

}
