package B;

import java.util.*;

public class MedicalSupplyChain {

    public static List<int[]> mergeIntervals(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException();
        }
        for (int[] interval : intervals) {
            if (interval == null || interval.length != 2 ||
                    interval[0] < 0 || interval[1] < interval[0]) {
                throw new IllegalArgumentException();
            }
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if (currentStart <= end + 1) {
                end = Math.max(end, currentEnd);
            } else {
                result.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }
        result.add(new int[]{start, end});
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        List<int[]> result = mergeIntervals(intervals);
        for (int[] interval : result) {
            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}
