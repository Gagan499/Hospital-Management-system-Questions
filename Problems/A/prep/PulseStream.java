package A.prep;

import java.util.*;

public class PulseStream {

    public static int[] maxSlidingWindow(int[] pulseStream, int K) {
        if (pulseStream == null || K <= 0 || K > pulseStream.length) {
            throw new IllegalArgumentException();
        }
        int n = pulseStream.length;
        int[] result = new int[n - K + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - K) {
                deque.pollFirst();
            }
            while (!deque.isEmpty()
                    && pulseStream[deque.peekLast()] <= pulseStream[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= K - 1) {
                result[index] = pulseStream[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] pulseStream = {78, 85, 82, 90, 88, 86};
        int K = 3;
        int[] result = maxSlidingWindow(pulseStream, K);
        System.out.println(Arrays.toString(result));
    }
}
