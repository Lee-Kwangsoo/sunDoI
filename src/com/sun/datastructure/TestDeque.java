package com.sun.datastructure;

import java.util.Deque;
import java.util.LinkedList;

public class TestDeque {
    //双向队列 先进先出  是支持在两个端插入和去除元素的线性集合。
    public static void main(String[] args) {
        Deque<Character> s=new LinkedList<Character>();
        s.push('s');
        s.push('u');
        s.push('n');
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s);
    }



}
