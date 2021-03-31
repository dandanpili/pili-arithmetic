package com.dandanpili.classload;

/**
 * @author shaoruilin
 * @create 2021-03-27-17:20
 */
public class ClassLoad {
    public static void main(String[] args) {
        System.out.println(SubClass.ABC);
    }
}

class SuperClass {
    static {
        System.out.println("SuperClass static init");
    }

    public final static String ABC = "abc";
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass static init");
    }
}