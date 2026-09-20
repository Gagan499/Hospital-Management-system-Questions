package B;

public class BloodBankPartition {

    public static void partition(int[] units, int pivot) {
        if (units == null) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = units.length - 1;
        while (left <= right) {
            while (left <= right && units[left] < pivot) {
                left++;
            }
            while (left <= right && units[right] >= pivot) {
                right--;
            }
            if (left <= right) {
                int temp = units[left];
                units[left] = units[right];
                units[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] units = {9, 12, 3, 5, 14, 7};
        int pivot = 8;
        partition(units, pivot);
        for (int value : units) {
            System.out.print(value + " ");
        }
    }
}
