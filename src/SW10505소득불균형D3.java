import java.util.Scanner;

public class SW10505소득불균형D3 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Integer T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            Integer len = sc.nextInt();
            Integer[] arr = new Integer[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            Double avg = getAvg(arr);
            System.out.println("#"+(test_case+1)+" " + getBelowAvg(avg, arr));
        }
    }

    public static Double getAvg(Integer[] arr){
        Double avg = 0D;
        Integer sum = 0;
        for (Integer a:
             arr) {
            sum += a;
        }
        return Double.valueOf(sum/arr.length);
    }

    public static Integer getBelowAvg(Double avg, Integer[] arr){
        Integer result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= avg) result += 1;
        }
        return result;
    }
}