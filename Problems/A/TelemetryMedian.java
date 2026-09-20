package A;

import java.util.*;

public class TelemetryMedian {

    private ArrayList<Integer> values = new ArrayList<>();

    public void insert(int value) {
        int position = Collections.binarySearch(values, value);
        if (position < 0) {
            position = -position - 1;
        }
        values.add(position, value);
    }

    public double getMedian() {
        if (values.isEmpty()) {
            throw new IllegalStateException();
        }
        int n = values.size();
        if (n % 2 == 1) {
            return values.get(n / 2);
        }
        return (values.get(n / 2 - 1) + values.get(n / 2)) / 2.0;
    }

    public static void main(String[] args) {
        TelemetryMedian telemetry = new TelemetryMedian();
        telemetry.insert(72);
        telemetry.insert(85);
        System.out.println(telemetry.getMedian());
        telemetry.insert(78);
        System.out.println(telemetry.getMedian());
    }
}