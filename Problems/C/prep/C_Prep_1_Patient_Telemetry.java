package C.prep;

public class C_Prep_1_Patient_Telemetry {

    public static double[] slidingWindowAverage(int[] vitals, int k) {
        if (vitals == null || k <= 0 || k > vitals.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        double[] result = new double[vitals.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += vitals[i];
        }
        result[0] = (double) sum / k;
        for (int i = k; i < vitals.length; i++) {
            sum += vitals[i];
            sum -= vitals[i - k];
            result[i - k + 1] = (double) sum / k;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] vitals = {92, 94, 96, 92, 90, 94, 98};
        int k = 3;
        double[] result = slidingWindowAverage(vitals, k);
        for (double value : result) {
            System.out.printf("%.1f ", value);
        }
    }
}
