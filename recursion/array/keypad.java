package com.recursion.array;
import java.util.*;
public class keypad {
    public static void main(String[] args) {
//        pad("","123");
        List<String> ans=letterCombinations("23");
        System.out.println(ans);
    }
//    static void pad(String p, String up) {
//        if (up.isEmpty()) {
//            System.out.println(p);
//            return;
//        }
//        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
//        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
//            char ch = (char) ('a' + i);
//            pad(p + ch, up.substring(1));
//        }
//
//    }
static public List<String> letterCombinations(String digits) {
      List<String> ans= new ArrayList<>();
      if(digits.length()==0){
          return ans;
      }
      StringBuilder output= new StringBuilder("");
      int index =0;
      String[] mapping ={"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
      solve(digits, output , index , ans, mapping);
      return ans;
}

   static private void solve(String digits, StringBuilder output, int index, List<String> ans, String[] mapping) {
        //base case
        if(index >= digits.length()){
            ans.add(output.toString());
            return;
        }
        int number = digits.charAt(index) - '0';
        String value = mapping[number];

        for (int i = 0; i < value.length(); i++) {
            output.append(value.charAt(i));
            solve(digits,output,index+1,ans, mapping);
            output.deleteCharAt(output.length()-1);
        }
    }

}


//class Solution {
//    private:
//    void solve(string digit, string output, int index, vector<string>& ans, string mapping[] ) {
//
//        //base case
//        if(index >= digit.length()) {
//            ans.push_back(output);
//            return;
//        }
//
//        int number = digit[index] - '0';
//        string value = mapping[number];
//
//        for(int i=0; i<value.length(); i++) {
//            output.push_back(value[i]);
//            solve(digit, output, index+1, ans, mapping);
//            output.pop_back();
//        }
//
//    }
//    public:
//    vector<string> letterCombinations(string digits) {
//        vector<string> ans;
//        if(digits.length()==0)
//            return ans;
//        string output;
//        int index = 0;
//        string mapping[10] = {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
//        solve(digits, output, index, ans, mapping);
//        return ans;
//    }
//};