package com.dandanpili.design.singleton;

/**
 * @author shaoruilin
 * @create 2021-03-21-13:43
 */
//单例模式的懒汉式双重检测模式
public class LazySingleton {
    //volatile 保证可见性和禁止指令重排序
    private static volatile LazySingleton lazySingleton;

    private LazySingleton() {

    }
    public static LazySingleton getInstance() {
        //第一次检查
        if (lazySingleton == null) {
            //同步代码块
            synchronized(LazySingleton.class) {
                //第二次检查
                if (lazySingleton == null) {
                    //对象实例化是一个非原子性操作
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public native int getInt();
}
