package com.gxuwz.medical.utils;

import java.util.Date;

/**
 * @author 麦奇
 * @date 2020-06-05 11:30
 */

public class UidCard {

    public static String uidCard() {
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

    public static void main(String[] args) {
        System.out.println(uidCard());
    }
}
