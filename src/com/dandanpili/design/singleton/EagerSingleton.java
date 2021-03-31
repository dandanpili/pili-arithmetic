package com.dandanpili.design.singleton;

/**
 * @author shaoruilin
 * @create 2021-03-19-18:28
 */
//单例模式的饿汉式
public class EagerSingleton {
    //私有化类的构造器，让外部无法使用
    private EagerSingleton() {

    }

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
