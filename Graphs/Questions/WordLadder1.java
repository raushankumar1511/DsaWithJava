package Graphs.Questions;

import java.util.*;
class pair {
    String first ;
    int second;
    public pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }

}
public class WordLadder1 {
    public int ladderLength(String startWord, String endWord, List<String> wordList) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(startWord,1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(startWord);

        while (!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();
             if(word.equals(endWord))return steps;
            for(int i = 0 ; i< word.length(); i++){
                char[] replacedCharArray = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new pair(replacedWord,steps + 1));
                    }
                }
            }
        }
    return 0;
    }
}
