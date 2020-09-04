import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SWE10580전봇대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int test_case = 1; test_case <= TC; test_case++) {
            int n = sc.nextInt();
            List<Line> list = new ArrayList<Line>();
            for (int i = 0; i < n; i++) {
                Line line = new Line(sc.nextInt(), sc.nextInt());
                list.add(line);
            }
            list.sort(Comparator.comparing(Line::getA).thenComparing(Line::getB));
//            list.forEach(System.out::println);
            int result =0;
            for (int idx = 0; idx < n-1; idx++) {
                List<Line> temp = list.subList(idx+1, list.size());
                result += getCross(temp, list.get(idx));
            }
            System.out.println( "#" + test_case+" "+ result);
        }
    }

    public static int getCross(List<Line> list, Line base){
//        for (Line line : list) {
//            System.out.println("cross " + line);
//        }
        int result = (int) list.stream().filter(ln -> ln.b < base.b).count();
        return result;
    }

    public static class Line{
        int a, b;
        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return "line{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
        public Line setA(int a) {
            this.a = a;
            return this;
        }
        public Line setB(int b) {
            this.b = b;
            return this;
        }
        public int getA() {
            return a;
        }
        public int getB() {
            return b;
        }
    }



}
