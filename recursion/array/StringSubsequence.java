package com.recursion.array;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSubsequence {
    public static void main(String[] args) {
        String st = "abc";
        System.out.println((subsequenceret("",st)));
    }
//    static void subsequence(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//
//        char ch = up.charAt(0);
//        subsequence(p+ch, up.substring(1));
//        subsequence(p, up.substring(1));
//    }
    static ArrayList<String> subsequenceret(String p, String up){
        ArrayList<String> ans = new ArrayList<>();
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

         char ch = up.charAt(0);
        ArrayList<String> ansLeft =subsequenceret(p+ch, up.substring(1));
        ArrayList<String> ansRight =subsequenceret(p, up.substring(1));

        ansLeft.addAll(ansRight);
        return ansLeft;
    }
}
