package com.sun.base1;

import com.sun.base.Qualifier;

public class QualifierC2 extends Qualifier {


    @Override
    protected void f() {
        super.f();
    }

    public static void main(String[] args) {
//        子类与基类不在同一包中：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的protected方法
        QualifierC2 c2=new QualifierC2();
        c2.f();

    }

}
