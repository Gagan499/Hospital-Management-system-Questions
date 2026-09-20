package A;

import java.util.*;

public class PharmacyInventory {

    public static int[] maxSlidingWindow(int[] dispensed, int K) {
        if (dispensed == null || K <= 0 || K > dispensed.length) {
            throw new IllegalArgumentException();
        }
        int n = dispensed.length;
        int[] result = new int[n - K + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - K) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() &&
                    dispensed[deque.peekLast()] <= dispensed[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= K - 1) {
                result[index] = dispensed[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] dispensed = {1, 3, -1, -3, 5, 3, 6, 7};
        int K = 3;
        int[] result = maxSlidingWindow(dispensed, K);
        System.out.println(Arrays.toString(result));
    }
}
