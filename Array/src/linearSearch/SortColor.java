package linearSearch;

import java.util.Arrays;

class SortColor {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }

    static public void sortColors(int[] nums) {
        int countZero=0, countOne=0,countTwo =0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                countZero++;
            } else if (nums[i] == 1) {
                countOne++;
            }else {
                countTwo++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i<countZero)nums[i]=0;
            else if(i>=countZero && i<countOne+countZero){
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }
        
    }
}
