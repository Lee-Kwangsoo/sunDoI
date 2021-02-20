package com.sun.base;

public class Qualifier {
    /**
     *  public protected default  private
     */
    protected void f(){

    }
    protected int var1;
    public int var2;
    int var3;
    private int var4;

    public void s(){


    }

    public static void main(String[] args) {
        Qualifier q1=new Qualifier();
        System.out.println(q1.var4);
    }

}
