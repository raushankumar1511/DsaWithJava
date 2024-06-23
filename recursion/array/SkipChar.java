package com.recursion.array;

public class SkipChar {
    public static void main(String[] args) {
        String st = "bacapplecdab";
        System.out.println(skip(st));
        System.out.println(skipString(st,"applec"));
    }

    //    static void skip ( String s, String ans){
//        if(s.isEmpty()){
//            System.out.println(ans);
//            return;
//        }
//
//        char ch = s.charAt(0);
//        if(ch == 'a'){
//            skip(s.substring(1),ans);
//        }else{
//            skip(s.substring(1) , ans + ch);
//        }
//    }
//}
    static String skip(String s) {
        if (s.isEmpty()) {
            return "";
        }

        char ch = s.charAt(0);
        if (ch == 'a') {
            return skip(s.substring(1));
        } else {
            return ch + skip(s.substring(1));
        }
    }


static String skipString( String s , String skip){
    if(s.isEmpty()){
        return "";
    }

    char ch = s.charAt(0);
    if(s.startsWith(skip)){
        return skipString(s.substring(skip.length()),skip);
    }else{
        return ch + skipString(s.substring(1),skip);
    }
}

}

