package com.microfian.prac.util;

import java.util.UUID;

public class LocalStringUtil {

    public static String getUUID(){

        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
