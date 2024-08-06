package com.study.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

    private CookieUtils(){

    }

    public static Cookie findCookie(String key,Cookie[] cookies){

        if(key == null || key.equals("") || cookies == null || cookies.length == 0){
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
