package B;

import java.util.*;

public class PatientVitalsMonitor {

    public static List<Integer> filterAlerts(int[] alerts, int K) {
        if (alerts == null || K <= 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < alerts.length; i++) {
            int alert = alerts[i];
            if (!lastIndex.containsKey(alert)) {
                result.add(alert);
            } else {
                int previousIndex = lastIndex.get(alert);
                if (i - previousIndex > K) {
                    result.add(alert);
                }
            }
            lastIndex.put(alert, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] alerts = {101, 102, 101, 103, 102, 105};
        int K = 2;
        List<Integer> result = filterAlerts(alerts, K);
        System.out.println(result);
    }
}
