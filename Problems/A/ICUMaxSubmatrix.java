package A;

import java.util.*;

public class ICUMaxSubmatrix {

    public static int maxSubmatrix(int[][] grid, int R, int C) {

        if (grid == null || grid.length == 0 ||
                grid[0] == null || grid[0].length == 0 ||
                R <= 0 || C <= 0) {
            throw new IllegalArgumentException();
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int[] row : grid) {
            if (row == null || row.length != cols) {
                throw new IllegalArgumentException();
            }
        }

        R = Math.min(R, rows);
        C = Math.min(C, cols);

        int answer = Integer.MIN_VALUE;

        for (int top = 0; top < rows; top++) {

            int[] columnSum = new int[cols];

            for (int bottom = top;
                 bottom < rows && bottom < top + R;
                 bottom++) {

                for (int col = 0; col < cols; col++) {
                    columnSum[col] += grid[bottom][col];
                }

                answer = Math.max(
                        answer,
                        maxSubarray(columnSum, C)
                );
            }
        }

        return answer;
    }

    public static int maxSubarray(int[] arr, int C) {

        int n = arr.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int best = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {

            while (!deque.isEmpty() &&
                    deque.peekFirst() < i - C) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                best = Math.max(
                        best,
                        prefix[i] - prefix[deque.peekFirst()]
                );
            }

            while (!deque.isEmpty() &&
                    prefix[deque.peekLast()] >= prefix[i]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return best;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, -1},
                {-3, 4, 2},
                {1, 1, 1}
        };

        int R = 2;
        int C = 2;

        System.out.println(maxSubmatrix(grid, R, C));
    }
}