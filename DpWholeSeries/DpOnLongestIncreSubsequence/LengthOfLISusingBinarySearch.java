package DpWholeSeries.DpOnLongestIncreSubsequence;

import java.util.*;

public class LengthOfLISusingBinarySearch {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.getLast()) {
                temp.add(nums[i]);
                len++;
            } else {
                int ind = Collections.binarySearch(temp, nums[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }
                temp.set(ind,nums[i]);
            }
        }
        return len;
    }
}
