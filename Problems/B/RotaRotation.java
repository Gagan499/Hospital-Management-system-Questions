package B;

public class RotaRotation {

    public static void rotateRight(int[] rota, int K) {
        if (rota == null) {
            throw new IllegalArgumentException();
        }
        int n = rota.length;
        if (n == 0) {
            return;
        }
        K = K % n;
        reverse(rota, 0, n - 1);
        reverse(rota, 0, K - 1);
        reverse(rota, K, n - 1);
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

    public static void main(String[] args) {
        int[] rota = {10, 20, 30, 40, 50};
        int K = 2;
        rotateRight(rota, K);
        for (int value : rota) {
            System.out.print(value + " ");
        }
    }
}