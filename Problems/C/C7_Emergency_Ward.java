package C;

public class C7_Emergency_Ward {
    public static int findFirstValidRoom(int[] capacities, int minCap) {
        if (capacities == null || capacities.length == 0) return -1;
        int low = 0;
        int high = capacities.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (capacities[mid] >= minCap) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] roomSizes = {2, 4, 6, 8, 12, 16};
        System.out.println("Match Index (Req 7): " + findFirstValidRoom(roomSizes, 7));
        System.out.println("Match Index (Req 20): " + findFirstValidRoom(roomSizes, 20));
    }
}
