import java.util.Scanner;

public class SWE10200구독자전쟁D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            Integer N = sc.nextInt();
            Integer a = sc.nextInt();
            Integer b = sc.nextInt();
//            System.out.println("#" + test_case + " " + (a > b ? b : a) + " " + ((a+ b) > N ? ((a+b) - N) : 0));
            System.out.println("#" + test_case + " " + getMax2(N, a, b) + " " + getMin2(N, a, b));
//            System.out.println("#" + test_case + " " + getMax(N, a, b) + " " + getMin(N, a, b));
        }

    }
    public static Integer getMax(Integer N, Integer a, Integer b){
        return a > b ? b : a;
    }
    public static Integer getMin(Integer N, Integer a, Integer b){
        return (a+ b) > N ? ((a+b) - N) : 0;
    }
    public static int getMax2(int N, int a, int b){
        if(a > b)  return b;
        return a;
    }
    public static int getMin2(int N, int a, int b){
        if((a+b) > N) return (a + b) - N;
        return 0;
    }
}
