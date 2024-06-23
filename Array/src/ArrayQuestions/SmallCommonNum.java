package ArrayQuestions;

class SmallCommonNum {
    public   static void main(String[] args) {
        int[] num1 ={3,5,6,7,8};
        int[] num2 = {6,8,9,10};
        System.out.println(getCommon(num1,num2));
    }
    public static int getCommon(int[] nums1, int[] nums2) {
        
       int i=0;
       int j=0;
    int n1= nums1.length;
    int n2 = nums2.length;

    if (nums1[n1-1] < nums2[0] || nums2[n2-1] < nums1[0]) return -1;

    while(i <n1 && j < n2){
            if(nums1[i]< nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                return nums2[j];
            }

        }
        return -1;
    }
}