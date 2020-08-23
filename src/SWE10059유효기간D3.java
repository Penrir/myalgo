import java.util.Scanner;

public class SWE10059유효기간D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.next();
            String first = input.substring(0, 2);
            String second = input.substring(2, input.length());
            sb
                .append("#")
                .append(test_case).append(" ")
                .append(getResult(first, second))
                .append("\n");
        }
        System.out.println(sb.toString());
    }
    public static boolean isMonth(String str){
        Integer i= Integer.parseInt(str);
        if( i > 0 && i < 13) return true;
        return false;
    }
    public static String getResult(String first, String second){
        if(isMonth(first) && isMonth(second)) return "AMBIGUOUS";
        if(isMonth(first)) return "MMYY";
        if(isMonth(second)) return "YYMM";
        return "NA";
    }
}
/*
카드 유효기간은 대개 월(01에서 12)과 년도 뒤 두자리(2021년이면 21)의 순서대로 나타나는데, 예를 들어 2021년 7월은 0721로 나타낸다.
그러나 가끔 년, 월 순서대로, 2107을 유효기간으로 표시하는 곳도 있다. 이 때, 전자를 MMYY표기, 후자를 YYMM표기라고 하자.

21은 1월에서 12월일 수 없기 때문에 0721은 MMYY표기라는 것을 알 수 있다.
하지만 2007년 5월을 예로 들었다면, 어떤 사람들은 이 날의 MMYY표기 0507를 YYMM표기로 받아들여 2005년 7월이라고 해석할 수 있다.

어떤 유효기간 표기 네 자리가 주어질 때, 이 유효기간이 어떤 표기로 나타낸 기간인지 판별하는 프로그램을 작성하라.

[입력]
첫 번째 줄에 테스트 케이스의 수 가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 네 자리 아라비아 숫자로 이루어진 문자열이 주어진다.

5
0721
2107
0507
0705
1313

[출력]
각 테스트 케이스마다 주어진 표기가 MMYY표기와 YYMM표기가 둘 다 될 수 있다면 “AMBIGUOUS”를, MMYY표기만 될 수 있다면 “MMYY”를, YYMM표기만 될 수 있다면 “YYMM”을, 둘 중 어떤 표기로도 나올 수 없다면 “NA”를 출력하라.
#1 MMYY
#2 YYMM
#3 AMBIGUOUS
#4 AMBIGUOUS
#5 NA

 */