package com.String.EasyQues;
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
// it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.
public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A mman, a plan, a canal: Panamma9";
      String s="0P";
        System.out.println(isPalindrome(s));
    }

   static public boolean isPalindrome(String s) {

      String s2=  s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

      int start=0;
      int end= s2.length()-1;
      while (start<=end){
          if (s2.charAt(start)!=s2.charAt(end))return false;
          start++;end--;
      }
      return true;
    }

//       static public boolean isPalindrome(String s) {
//            int i = 0, j = s.length()-1;
//
//            while (i<j) {
//                char ci = lowercaseAlphaNumeric(s.charAt(i));
//                if (ci == 0) {
//                    i++;
//                    continue;
//                }
//                char cj = lowercaseAlphaNumeric(s.charAt(j));
//                if (cj == 0) {
//                    j--;
//                    continue;
//                }
//                if (ci != cj) return false;
//                i++;
//                j--;
//            }
//            return true;
//        }
//
//        /**
//         * If c is alphanumeric returns lowercase c, otherwise, 0
//         */
//       static private char lowercaseAlphaNumeric(char c) {
//            if ((c >=48 && c <= 57) // 0-9
//                    || (c >= 97 && c <= 122)) // a-z
//                return c;
//            else if (c >= 65 && c <= 90) return (char)(c+32); // A-Z
//            return 0;
//        }


}
