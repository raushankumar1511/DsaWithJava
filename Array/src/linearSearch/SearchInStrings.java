package linearSearch;

public class SearchInStrings {
    public static void main(String[] args) {
        String str="raushan";
        char target='k';
        System.out.println(search(str,target));
    }
    public static boolean search(String sh, char target){
        if(sh.length()==0){
            return false;
        }
        for(int i=0;i<sh.length();i++){
            if(sh.charAt(i)==target){
                return true;
            }
        }
        return false;
    }
}
