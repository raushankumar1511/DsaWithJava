package linearSearch;

public class Linearserch {
    public static void main(String[] args) {
        int[] arr={3,25,74,2,7,1,5};
       int position = linearsearch(arr,25);
       if(position==-1){
           System.out.println("Element not found in array");
       }else{
           System.out.println("Element present at index : "+ position);
       }
    }
    static int linearsearch(int[] arr,int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target)
                return i;

        }
        return -1;

    }
}
