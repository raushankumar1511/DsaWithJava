package ArrayQuestions;

class FindPivot {
    public static void main(String[] args) {
        for (int n =1;n<=50;n++)
           System.out.println(pivotInteger(n));
    }
    public static int pivotInteger(int n) {

        int sum = n*(n+1)/2;
        int pre_sum = 0;
        for(int i =1; i<= n ; i++){
            pre_sum += i;
            if((sum - pre_sum) +i  == pre_sum){
                return i;
            }
        }

        return -1;
    }
}