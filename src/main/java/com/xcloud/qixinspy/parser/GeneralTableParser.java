package com.xcloud.qixinspy.parser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class GeneralTableParser {

    public List<List<String>> parse(WebElement element) {
        List<List<String>> tbodylist = new ArrayList<List<String>>();
        List<String> trlist = new ArrayList<String>();
        tbodylist.add(trlist);
        return tbodylist;
    }

}
