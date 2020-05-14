package com.base;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
public class EnumUse {
    public static void main(String[] args) {
        Family s = Family.FATHER;

        for (Family family : Family.values()) {
            System.out.println(family + ", ordinal" + family.ordinal());
        }
    }
}
