package C;

public class C6_Patient_Check_In {
    private static int[] check_in;
    public C6_Patient_Check_In(int[] check_in){
        this.check_in = check_in;
    }

    public static int findMinGap(){
        int min = Integer.MAX_VALUE;
        for(int i=1;i<check_in.length;i++){
            int diff = Math.abs(check_in[i] - check_in[i-1]);
            if(diff<min){
                min = Math.min(min,diff);
            }
        }
        return min;

    }

    public static void main(String[] args) {
        int[] check_in = {1710000500, 1710000000,1710000200};
        C6_Patient_Check_In obj = new C6_Patient_Check_In(check_in);
        System.out.println(obj.findMinGap());
    }
}
