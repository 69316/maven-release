package com.example.mavenrelease.controller;

/**
 * @Description: 单例模式结构
 * @ClassName :  Singleton
 * @Author: xwl
 * @Date: 2022/6/24 14:03
 **/
public class Singleton {
    /**
     * 1.构造器私有化(防止外部new一个实例化对象)
     * 2.类的内部创建对象
     * 3.给外部提供一个方法获取实例化对象
     */
    private Singleton() {
    }

    /**
     * 饿汉式-静态变量方式
     * 优点：写法简单，在类加载的时候就创建对象，避免线程同步问题
     * 缺点：随着类的加载，对象也随之创建好，如果不调用，就会浪费内存空
     * private static Singleton singleton = new Singleton();
     */
    private static Singleton singleton;

    /**
     * 饿汉式-静态代码块方式
     * static {
     *   singleton = new Singleton();
     * }
     */

    /**
     * 懒汉式(线程安全)
     * 优点：解决了线程安全问题
     * 缺点：效率较低，真正出现线程安全问题的是实例化那一步，
     * 当实例化完成后，以后访问只需要返回对象即可，不需要保证线程安全。
     * 但是此方法则每次访问时都保证线程安全
     * public static synchronized Singleton getInstance() {
     * if(singleton==null){
     * singleton = new Singleton();
     * }
     * }
     */
    public static synchronized Singleton getInstance() {
        /**
         * 懒汉式(线程不安全)
         * 优点：实现了懒加载
         * 缺点：多线程环境下，当一线程进入singleton==null时，另一个线程进入，这时就会创建多个实例对象，出现线程不安全的问题
         *  if(singleton==null){
         *     singleton = new Singleton();
         *  }
         */


        /**
         * 懒汉式(双重检查锁)
         * if (singleton == null) {
         *     synchronized (Singleton.class) {
         *         if (singleton == null) {
         *              singleton = new Singleton();
         *          }
         *     }
         * }
         *
         */

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
