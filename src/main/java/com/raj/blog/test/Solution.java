package com.raj.blog.test;

public class Solution {

    public int toBinary(int number){
        String s = Integer.toString(number, 2);
        System.out.println(s);
        return 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.toBinary(3);
    }
}
