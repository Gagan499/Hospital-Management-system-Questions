package B.prep;

import java.util.*;

public class ClinicOverlapScanner {

    public static boolean hasOverlap(int[][] appointments) {

        if (appointments == null) {
            throw new IllegalArgumentException();
        }

        if (appointments.length <= 1) {
            return false;
        }

        for (int[] appointment : appointments) {
            if (appointment == null ||
                    appointment.length != 2 ||
                    appointment[0] < 0 ||
                    appointment[0] >= appointment[1] ||
                    appointment[1] > 1440) {
                throw new IllegalArgumentException();
            }
        }

        Arrays.sort(appointments, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < appointments.length; i++) {

            if (appointments[i][0] < appointments[i - 1][1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] appointments = {
                {10, 30},
                {50, 70},
                {20, 40}
        };

        System.out.println(hasOverlap(appointments));
    }
}