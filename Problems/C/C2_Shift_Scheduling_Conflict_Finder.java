package C;

import java.util.Arrays;

public class C2_Shift_Scheduling_Conflict_Finder {
    private static int[][] shifts;

    public C2_Shift_Scheduling_Conflict_Finder(int[][] shifts){this.shifts = shifts;}

    public static boolean findconflict(){
        Arrays.sort(shifts,(a,b)->a[0]-b[0]);
        for(int i=1;i<shifts.length;i++){
            if(shifts[i-1][1]>shifts[i][0]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] shifts = {{9,12},{14, 17},{11, 15}};
        C2_Shift_Scheduling_Conflict_Finder obj = new C2_Shift_Scheduling_Conflict_Finder(shifts);
        System.out.println(findconflict());
    }
}
