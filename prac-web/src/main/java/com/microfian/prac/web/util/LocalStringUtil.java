package com.microFian.prac.web.util;

import java.util.UUID;

public class LocalStringUtil {

    public static String getUUID(){

        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
