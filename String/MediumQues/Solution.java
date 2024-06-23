package com.String.MediumQues;

public class Solution {
    public static void main(String[] args) {
        String version1 = "1.001";
        String version2 = "1.1";
        System.out.println(compareVersion(version1,version2));
    }
    public static int compareVersion(String version1, String version2) {
        int i = 0;
        int num1=0;
        int num2=0;
       while(i<version1.length()){
           if(version1.charAt(i)=='.'){
              num1 =( num1 *10 )+ Integer.valueOf(version1.substring(0,i));
               version1 = version1.substring(i+1);
               i =0;
               continue;
           }
           i++;
       }
        num1 =( num1 *10 )+ Integer.valueOf(version1.substring(0,i));
i=0;
        while(i<version2.length()){
            if(version2.charAt(i)=='.'){
                num2 =( num2 *10 )+ Integer.valueOf(version2.substring(0,i));
                version2 = version2.substring(i+1);
                i =0;
                continue;
            }
            i++;
        }
        num2 =( num2 *10 )+ Integer.valueOf(version2.substring(0,i));

        if(num1 < num2){
            return -1;
        } else if (num1 > num2) {
            return 1;
        }
        return 0;


//        while(version1.length() >0 && version2.length() >0){
//
//            int i =0;
//            int j=0;
//            while(i <version1.length() && version1.charAt(i) != '.'){
//                i++;
//            }
//            int revisionV0 =Integer.valueOf(version1.substring(0,i));
//            while(j <version2.length() &&version2.charAt(j) != '.'){
//                j++;
//            }
//            int revisionV1 =Integer.valueOf(version2.substring(0,j));
//            if(revisionV0 < revisionV1){
//                return -1;
//            }
//            if(revisionV0 > revisionV1){
//                return 1;
//            }
//            if(i< version1.length()){
//                version1 = version1.substring(i+1);
//            }else {
//                break;
//            }
//            if(j< version2.length()){
//                version2 = version2.substring(i+1);
//            }else {
//                break;
//            }
//
//        }
//
//        return 0;
    }
}