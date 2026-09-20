package C;

public class C4_Patient_Lab_Result {
    private static int[] readings;
    public C4_Patient_Lab_Result(int[] readings){
        this.readings = readings;
    }
    public static int longestIncreasingTrajectory(){
        int max =0;
        int cnt =1;
        for(int i=0;i<readings.length;i++){
           if(i+1<readings.length && readings[i] < readings[i+1]){
               cnt++;
           }
           else{
               max= Math.max(max,cnt);
               cnt=1;
           }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] readings = {10,22,9,33,40,50,41,60};
        C4_Patient_Lab_Result obj = new C4_Patient_Lab_Result(readings);
        System.out.println(longestIncreasingTrajectory());
    }
}
