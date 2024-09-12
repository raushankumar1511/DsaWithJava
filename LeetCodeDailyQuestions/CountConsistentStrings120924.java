package LeetCodeDailyQuestions;

import java.util.*;

public class CountConsistentStrings120924 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char ch : allowed.toCharArray()){
            set.add(ch);
        }

        int count = 0;
        for(String word : words){
            boolean isPresent = true;
            for(char ch : word.toCharArray()){
                if(!set.contains(ch)){
                    isPresent = false;
                    break;
                }
            }
            if(isPresent)count++;
        }
        return count;
    }
}
