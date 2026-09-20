package A;

import java.util.*;

public class ICUWindow {

    public static int[] findBestWindow(int[] vitals, int[] patients, int K) {
        if (vitals == null || patients == null ||
                vitals.length != patients.length || K < 0) {
            throw new IllegalArgumentException();
        }
        int n = vitals.length;
        if (n == 0) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        long sum = 0;
        long bestSum = -1;
        int bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += patients[right];
            while (!maxDeque.isEmpty() &&
                    vitals[maxDeque.peekLast()] <= vitals[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            while (!minDeque.isEmpty() &&
                    vitals[minDeque.peekLast()] >= vitals[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            while (vitals[maxDeque.peekFirst()] -
                    vitals[minDeque.peekFirst()] > K) {
                sum -= patients[left];
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }
            int length = right - left + 1;
            if (sum > bestSum ||
                    (sum == bestSum && length < bestLength)) {
                bestSum = sum;
                bestLength = length;
            }
        }

        return new int[]{(int) bestSum, bestLength};
    }

    public static void main(String[] args) {
        int[] vitals = {10, 11, 12, 20, 21};
        int[] patients = {1, 2, 3, 4, 5};
        int K = 2;
        int[] result = findBestWindow(vitals, patients, K);
        System.out.println(Arrays.toString(result));
    }
}
