package com.study.Util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    private CookieUtils(){

    }

    public static Cookie findCookie(String key,Cookie[] cookies){

        if(key == null || key.equals("") || cookies == null){
            return null;
        }

        for (Cookie cookie : cookies) {

            if(key.equals(cookie.getName())){
                return cookie;
            }

        }

        return null;
    }

}
