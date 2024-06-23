package com.practiceBinarySearch;

import java.util.*;
import java.util.Collections;

public class Segregate01 {
    public static void main(String[] args) {
//        List<Integer> arr = {1,0,0,1,1,0,1,1,0};
        List<Integer> arr=Arrays.asList(1,0,0,1,1,0,1,1,0);
        segregate01(arr);
        System.out.println(arr);

    }
    static void segregate01(List<Integer> arr){
        int s=0;
        int e= arr.size()-1;
        while (s<e){
            while(arr.get(s)==0){
                s++;
            }
            while (arr.get(e)==1){
                e--;
            }

                Collections.swap(arr, s, e);
                s++;
                e--;
        }

    }
}
