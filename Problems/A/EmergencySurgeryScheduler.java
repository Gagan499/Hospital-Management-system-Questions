package A;

import java.util.*;

public class EmergencySurgeryScheduler {

    public static int maxSeverity(int[][] surgeries) {
        if (surgeries == null) {
            throw new IllegalArgumentException();
        }
        for (int[] surgery : surgeries) {
            if (surgery == null || surgery.length != 3 ||
                    surgery[0] >= surgery[1] ||
                    surgery[0] < 1 ||
                    surgery[1] > 100000 ||
                    surgery[2] < 1 ||
                    surgery[2] > 1000000) {
                throw new IllegalArgumentException();
            }
        }

        Arrays.sort(surgeries, (a, b) ->
                Integer.compare(a[1], b[1])
        );
        int n = surgeries.length;
        int[] dp = new int[n];
        dp[0] = surgeries[0][2];
        for (int i = 1; i < n; i++) {
            int include = surgeries[i][2];
            int previous = findPrevious(surgeries, i);
            if (previous != -1) {
                include += dp[previous];
            }
            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n - 1];
    }

    public static int findPrevious(int[][] surgeries, int index) {
        int startTime = surgeries[index][0];
        int left = 0;
        int right = index - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (surgeries[mid][1] <= startTime) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] surgeries = {
                {1, 3, 50},
                {2, 4, 10},
                {3, 5, 40},
                {3, 6, 70}
        };
        System.out.println(maxSeverity(surgeries));
    }
}