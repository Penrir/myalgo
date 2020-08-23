import java.util.Scanner;

public class SW10505소득불균형 {
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

/*

통계 자료를 처리할 때, 평균이 전체 집단의 특징을 꼭 잘 표현하는 것은 아니다.

예를 들어, 대다수의 국가에서는 적은 수의 사람이 국가 전체 소득의 꽤 많은 부분을 차지하기 때문에, 해당 국가의 평균 소득은 보통 사람들의 소득보다 높은 경우가 많다.

당신은, n명의 사람의 소득이 주어졌을 때 이 중 평균 이하의 소득을 가진 사람들의 수를 출력해야 한다.


[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

이후 T개의 테스트 케이스에 대해 각각 두 줄로 주어진다.

첫 번째 줄에는 정수의 개수 N 이 주어지며(1 ≤ N ≤ 10,000), 두 번째 줄에는 각 사람의 소득을 뜻하는 N개의 양의 정수가 주어진다. 이 정수들은 각각 1 이상 100,000 이하이다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 한 줄씩 평균 이하의 소득을 가진 사람들의 수를 출력한다.

입력입력 복사
3                           // 전체 테스트 케이스 수
7                           // 첫 번째 테스트 케이스 N=7
15 15 15 15 15 15 15
10                          // 두 번째 테스트 케이스 N=10
1 1 1 1 1 1 1 1 1 100
7
2 7 1 8 2 8 4

#1 7                        // 첫 번째 테스트 케이스의 답
#2 9
#3 4

 */