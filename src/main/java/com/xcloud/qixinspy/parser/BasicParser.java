package com.xcloud.qixinspy.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xcloud.qixinspy.db.dao.QyDao;
import com.xcloud.qixinspy.db.model.QyVO;
import com.xcloud.qixinspy.db.model.QyfzjgVO;
import com.xcloud.qixinspy.db.model.QygdxxVO;
import com.xcloud.qixinspy.db.model.QyzyryVO;

@Transactional
public class BasicParser {

    @Autowired
    private QyDao qyDao;

    public String parseQy(String uuid, WebDriver driver) {
        QyVO vo = new QyVO();
        vo.setUuid(uuid);
        vo.setQymc(driver
                .findElement(By.cssSelector(
                        "body > div.company.with-min-height > div.container > div.col-xs-9.company-right > div.section.company-info.clearfix > div.company-summary > div.company-name > h1 > span.company-name-now"))
                .getText());
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

    public String parseQygdxx(String zjh, WebDriver driver) {
        QygdxxVO vo = new QygdxxVO();
        return vo.toString();
    }

    public String parseQyzyry(String zjh, WebDriver driver) {
        QyzyryVO vo = new QyzyryVO();
        return vo.toString();
    }

    public String parseQyfzjg(String zjh, WebDriver driver) {
        QyfzjgVO vo = new QyfzjgVO();
        return vo.toString();
    }

}
