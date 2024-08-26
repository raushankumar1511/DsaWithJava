package DpWholeSeries.DpOnSubSequence;
import java.util.*;
public class PartitionArrayOfSameSizeToMinimizeAbsDiff {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int N = n / 2;
        List<List<Integer>> left = new ArrayList<>(N + 1);
        List<List<Integer>> right = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; ++i) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        // Storing all possible sums in left and right parts
        for (int mask = 0; mask < (1 << N); ++mask) {
            int sz = 0, l = 0, r = 0;
            for (int i = 0; i < N; ++i) {
                if ((mask & (1 << i)) != 0) {
                    sz++;
                    l += nums[i];
                    r += nums[i + N];
                }
            }
            left.get(sz).add(l);
            right.get(sz).add(r);
        }

        for (int sz = 0; sz <= N; ++sz) {
            Collections.sort(right.get(sz));
        }

        int res = Math.min(Math.abs(sum - 2 * left.get(N).get(0)), Math.abs(sum - 2 * right.get(N).get(0)));

        // Iterating over left part
        for (int sz = 1; sz < N; ++sz) {
            for (int a : left.get(sz)) {
                int b = (sum - 2 * a) / 2;
                List<Integer> v = right.get(N - sz);

                int idx = Collections.binarySearch(v, b);
                if (idx < 0) {
                    idx = -idx - 1;
                }

                if (idx < v.size()) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + v.get(idx))));
                }
                if (idx > 0) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + v.get(idx - 1))));
                }
            }
        }

        return res;
    }
}
