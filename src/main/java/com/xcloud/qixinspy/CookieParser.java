package com.xcloud.qixinspy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CookieParser {

    public static List<Cookie> parse(String json) {
        List<Cookie> cookies = new ArrayList<Cookie>();
        JsonParser parser = new JsonParser();
        JsonArray array = (JsonArray) parser.parse(json);
        for (int i = 0; i < array.size(); i++) {
            JsonObject ck = array.get(i).getAsJsonObject();
            Cookie cookie = new Cookie(ck.get("name").getAsString(), ck.get("value").getAsString(),
                    ck.get("path").getAsString());
            cookies.add(cookie);
        }
        return cookies;
    }

}
