package DpWholeSeries.DpOnLongestIncreSubsequence;
import java.util.*;

public class LongestDivisibleSubsets {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int [] hash = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;
        int lastIndex = 0;
        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for(int prev = 0 ;prev < ind; prev++){
                if(nums[ind] % nums[prev] == 0 && 1+ dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }
            if(dp[ind] > maxi){
                maxi = dp[ind];
                lastIndex = ind;
            }
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex ){
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }
        Collections.reverse(temp);
        return temp;

    }
}
