package A.prep;

import java.util.*;

public class LayeredResourceMatrix {

    public static void rotateLayers(int[][] supplyGrid, int K) {
        if (supplyGrid == null || supplyGrid.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = supplyGrid.length;
        for (int[] row : supplyGrid) {
            if (row == null || row.length != n) {
                throw new IllegalArgumentException();
            }
        }
        int layerCount = n / 2;
        for (int layer = 0; layer < layerCount; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            int length = 4 * (last - first);
            if (length == 0) {
                continue;
            }
            K = K % length;
            if (K == 0) {
                continue;
            }
            int[] values = new int[length];
            int index = 0;
            for (int col = first; col <= last; col++) {
                values[index++] = supplyGrid[first][col];
            }
            for (int row = first + 1; row <= last; row++) {
                values[index++] = supplyGrid[row][last];
            }
            for (int col = last - 1; col >= first; col--) {
                values[index++] = supplyGrid[last][col];
            }
            for (int row = last - 1; row > first; row--) {
                values[index++] = supplyGrid[row][first];
            }
            reverse(values, 0, length - 1);
            reverse(values, 0, K - 1);
            reverse(values, K, length - 1);
            index = 0;
            for (int col = first; col <= last; col++) {
                supplyGrid[first][col] = values[index++];
            }
            for (int row = first + 1; row <= last; row++) {
                supplyGrid[row][last] = values[index++];
            }
            for (int col = last - 1; col >= first; col--) {
                supplyGrid[last][col] = values[index++];
            }
            for (int row = last - 1; row > first; row--) {
                supplyGrid[row][first] = values[index++];
            }
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void printGrid(int[][] grid) {

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] supplyGrid = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int K = 1;
        rotateLayers(supplyGrid, K);
        printGrid(supplyGrid);
    }
}
