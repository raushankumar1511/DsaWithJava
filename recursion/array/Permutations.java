package com.recursion.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutations {
    public static void main(String[] args) {
//          String s ="123456789";
//          ArrayList<String> ans = permutationsReturn("",s);
//        Collections.sort(ans);
//        System.out.println(ans);
        StringBuilder s= new StringBuilder("123");
        permute(s,0,3);
    }

//    static void permutations(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//
//        char ch = up.charAt(0);
//        for (int i = 0; i <= p.length(); i++) {
//            String f= p.substring(0,i);
//            String g = p.substring(i,p.length());
//            permutations(f+ch+g, up.substring(1));
//        }
//    }
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = p.length(); i >= 0; i--) {
            String f= p.substring(0,i);
            String g = p.substring(i,p.length());
            permutations(f+ch+g, up.substring(1));
        }
    }
    static ArrayList<String> permutationsReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = p.length(); i >= 0; i--) {
            String f= p.substring(0,i);
            String g = p.substring(i,p.length());
            ans.addAll(permutationsReturn(f+ch+g, up.substring(1)));
        }
        return ans;
    }

    static void permute(StringBuilder s,int i , int k){
        if(i==s.length()-1){
            System.out.println(s);
            return;
        }
        for(int j =i;j<s.length();j++){
            swap(s,i,j);
            permute(s,i+1,k);
            swap(s,j,i);
        }
    }
    static void swap(StringBuilder s,int i,int j){
        char temp = s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,temp);
    }
}
