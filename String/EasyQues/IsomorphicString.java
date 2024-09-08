class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m)return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        
        int i = 0;
        int j = 0;

        while(i<n){
            char ch1 =s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)){
               if(map1.get(ch1) == ch2) i++;
               else{
                return false;
               }
            }else if(map2.containsKey(ch2)){
               if(map2.get(ch2) == ch1) i++;
               else return false;
            }
            else{
                map1.put(ch1,ch2);
                map2.put(ch2,ch1);
                i++;
            }
        }
        return true;

    }
}
