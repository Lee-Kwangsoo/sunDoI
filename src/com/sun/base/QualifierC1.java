package com.sun.base;

public class QualifierC1 extends Qualifier{
    public static void main(String[] args) {
        //子类与基类在同一包中：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；
        QualifierC1 c1=new QualifierC1();
        c1.f();

    }
}
