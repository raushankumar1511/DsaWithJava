package ArrayQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class MInNoOfArrows {
    public static void main(String[] args) {
//        int[][] ballons = {{10,16},{2,8},{1,6},{7,12}};
        int[][] ballons = {{1,2},{2,3},{2,4},{2,6}};

        System.out.println(findMinArrows(ballons));
    }

    private static int findMinArrows(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[0], second[0]);
            }
        });
        int count = 0;

        int currArrowAt = arr[0][1];
        for(int[] sphere: arr){
            if(currArrowAt >= sphere[0] && currArrowAt <= sphere[1]){
                continue;
            }else {
                if(sphere[1]<currArrowAt){
                    currArrowAt = sphere[1];
                    continue;
                }
                else{
                    count++;
                    currArrowAt = sphere[1];
                }
            }
        }
        return count+1;
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;
        long prevlast = points[0][1]; // Use long to handle large numbers

        for (int i = 1; i < points.length; i++) {
            if (prevlast >= points[i][0]) {
                if (prevlast > points[i][1]) {
                    prevlast = points[i][1];
                }
            } else {
                prevlast = points[i][1];
                count++;
            }
        }

        return count + 1;
    }
}
