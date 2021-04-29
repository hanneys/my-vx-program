package com.eve.util;

import com.eve.entity.User;

/**
 * @Author hanneys
 * @Date 2021/4/27 18:12
 * @Version 1.0
 */
public class UserUtil {

    private UserUtil(){ }

    private static final ThreadLocal<User> USER_INFO = new ThreadLocal<>();

    public static void set(User userInfo) {
        USER_INFO.set(userInfo);
    }


    public static User get() {
        return USER_INFO.get();
    }

    public static void remove() {
        USER_INFO.remove();
    }

}
