package ArrayQuestions;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[0], second[0]);
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.getLast()[1]) {
                ans.add(arr[i]);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], arr[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
