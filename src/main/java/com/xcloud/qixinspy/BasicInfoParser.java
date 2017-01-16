package com.xcloud.qixinspy;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xcloud.qixinspy.db.dao.QyDao;
import com.xcloud.qixinspy.db.model.QyVO;

@Transactional
public class BasicInfoParser {

    @Autowired
    private QyDao qyDao;

    public String parse(String uuid, String name, WebDriver driver) {
        QyVO vo = new QyVO();
        vo.setUuid(uuid);
        vo.setQymc(name);
        vo.setZjh(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(2) > td:nth-child(2)"))
                .getText());
        vo.setTyshxydm(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(1) > td:nth-child(2)"))
                .getText());
        vo.setZzjgdm(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(1) > td:nth-child(4)"))
                .getText());
        vo.setJyzt(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(2) > td:nth-child(4)"))
                .getText());
        vo.setGslx(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(3) > td:nth-child(2)"))
                .getText());
        try {
            String date = driver
                    .findElement(By.cssSelector(
                            "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(3) > td:nth-child(4)"))
                    .getText();
            vo.setClrq(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        vo.setFddbr(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(4) > td:nth-child(2) > a:nth-child(1)"))
                .getText());
        vo.setYyqx(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(4) > td:nth-child(4)"))
                .getText());
        vo.setZczb(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(5) > td:nth-child(2)"))
                .getText());
        vo.setFzrq(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(5) > td:nth-child(4)"))
                .getText());
        vo.setDjjg(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(6) > td:nth-child(2)"))
                .getText());
        vo.setQydz(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(7) > td:nth-child(2)"))
                .getText());
        vo.setJyfw(driver
                .findElement(By.cssSelector(
                        "#info > div:last-child > div.panel.panel-default.basic-info > div > table > tbody > tr:nth-child(8) > td:nth-child(2)"))
                .getText());
        qyDao.deleteById(vo);
        qyDao.insert(vo);
        return vo.toString();
    }

}
