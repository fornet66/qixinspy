package com.xcloud.qixinspy.parser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralTableParser {

    public List<List<String>> parse(WebElement element) {
        List<List<String>> rows = new ArrayList<List<String>>();
        List<WebElement> trs = element.findElements(By.tagName("tr"));
        for (WebElement tr : trs) {
            List<String> values = new ArrayList<String>();
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            for (WebElement td : tds) {
                String value = td.getText();
                values.add(value);
            }
            rows.add(values);
        }
        return rows;
    }

}
