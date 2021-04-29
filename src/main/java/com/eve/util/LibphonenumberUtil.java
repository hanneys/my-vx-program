package com.eve.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * @Author hanneys
 * @Date 2021/4/28 9:43
 * @Version 1.0
 */
public class LibphonenumberUtil {

    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();


    private static final String DEFAULT_COUNTRY = "CN";


    /**
     * @Author: hanneys
     * @Description ① 可以加区号，也可以不加，区号默认86
     * ② 区号前面的“+”和“00”占位可加可不加
     * ② 手机号中间可以增加“-”
     * @param phone “+8617717031234 +008617717031234 8617717031234 177-1703-1234”
     * @Date: 2018/5/9 9:21
     */
    public static boolean doValidUniversal(String phone) {
        Phonenumber.PhoneNumber phoneNumber = doParse(phone);
        return phoneNumber.hasNationalNumber() && doValid(phoneNumber.getNationalNumber() + "", phoneNumber.getCountryCode() + "");
    }


    /**
     * @Author: hanneys
     * @Description 电话解析逻辑
     * @param phone “+8617717031234 +008617717031234 8617717031234 177-1703-1234””
     * @return 电话实体类 Phonenumber.PhoneNumber
     * @Date: 2018/5/9 9:21
     */
    public static Phonenumber.PhoneNumber doParse(String phone) {
        try {
            return phoneNumberUtil.parse(phone, DEFAULT_COUNTRY);
        } catch (NumberParseException e) {
            throw new NumberFormatException("invalid phone number: " + phone);
        }
    }
    /**
     * @Author: hanneys
     * @Description 手机校验逻辑
     * @param phoneNumber 手机号
     * @param countryCode 手机区号
     * @Date: 2018/5/9 9:21
     */
    public static boolean doValid(String phoneNumber, String countryCode){
        int ccode = Integer.parseInt(countryCode);
        long phone = Long.parseLong(phoneNumber);
        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        pn.setCountryCode(ccode);
        pn.setNationalNumber(phone);
        return phoneNumberUtil.isValidNumber(pn);
    }
}
