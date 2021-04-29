package com.eve.util;

import java.util.Random;

/**
 * @Author hanneys
 * @Date 2021/4/27 21:05
 * @Version 1.0
 */
public class VerifyCodeUtil {

    public static String getCode(){
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }
}
