package linearSearch;

class JumpGame {
    public static void main(String[] args) {
        int[] nums= {2,5,0,0,0,0};
        System.out.println(canJump(nums));
    }
    static public boolean canJump(int[] nums) {
       int finalPosition = nums.length-1;
          
          for(int ind = nums.length-2;ind>=0; ind--){
              if(ind +nums[ind]>= finalPosition ){
                  finalPosition = ind;
              }
          }
          
          //if destination reches to the first index then return true else false
          return finalPosition ==0;
    }
}