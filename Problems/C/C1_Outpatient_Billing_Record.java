package C;

import java.util.Scanner;

public class C1_Outpatient_Billing_Record {
    private static int[] prefix_sum;

    public C1_Outpatient_Billing_Record(int[] billing) {
        if (billing.length == 0) {
            throw new IllegalArgumentException("Billings logs can't find");
        }

        prefix_sum = new int[billing.length + 1];

        for (int i = 0; i < billing.length; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + billing[i];
        }
    }

    public int queryRange(int l, int r) {
        if (l < 0 || r >= prefix_sum.length - 1 || l > r) {
            throw new IllegalArgumentException(
                    "Requested audit window falls outside records."
            );
        }

        return prefix_sum[r + 1] - prefix_sum[l];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] billing = new int[n];

        for (int i = 0; i < n; i++) {
            billing[i] = sc.nextInt();
        }

        C1_Outpatient_Billing_Record obj =
                new C1_Outpatient_Billing_Record(billing);

        System.out.println("Query result 1 : " + obj.queryRange(0, 2));
        System.out.println("Query result 2 : " + obj.queryRange(1, 4));

        sc.close();
    }
}