import java.util.Arrays;
import java.util.Scanner;

public class DailyPractice_Example {
    static int[] arr = {1,2,3};
    static boolean[] check = new boolean[arr.length];
    public static void main(String[] args) {
        System.out.println("Subset");
        Subset(new boolean[arr.length], 0);

        System.out.println("Permutation");
        Permutation(new int[arr.length], 0);

        System.out.println("Repermutation");
        Repermutation(new int[arr.length], 0);

        System.out.println("Combination");
        Combination(new int[arr.length-1], 0, 0);

        System.out.println("Recombination");
        Recombination(new int[arr.length-1], 0, 0);
    }
    private static void Recombination(int[] ans, int idx, int r) {
        if(r == ans.length) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        if(idx == arr.length) return;
        ans[r] = arr[idx];
        Recombination(ans, idx, r+1);
        Recombination(ans, idx+1, r);
    }
    private static void Combination(int[] ans, int idx, int r) {
        if(r == ans.length) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        if(idx == arr.length) return;
        ans[r] = arr[idx];
        Combination(ans, idx+1, r+1);
        Combination(ans, idx+1, r);
    }
    private static void Repermutation(int[] ans, int idx) {
        if(idx == ans.length) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        for(int i=0; i<ans.length; i++) {
            ans[idx] = arr[i];
            Repermutation(ans, idx+1);
        }
    }
    private static void Permutation(int[] ans, int idx) {
        if(idx == ans.length) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        for(int i=0; i<ans.length; i++) {
            if(!check[i]) {
                check[i] = true;
                ans[idx]=arr[i];
                Permutation(ans, idx+1);
                check[i] = false;
            }
        }
    }
    private static void Subset(boolean[] ans, int idx) {
        if(idx == ans.length) {
            for(int i=0; i<ans.length; i++) {
                if(ans[i]) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        ans[idx] = true;
        Subset(ans, idx+1);
        ans[idx] = false;
        Subset(ans, idx+1);
    }

    public static class 최공 {
        public static int gcd(int x, int y) { //최대공약
            if(y==0) return x;
            else return gcd(y, x%y);
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int g = gcd(a,b);
            int l = a * b / g; //<< 최소공배수
            System.out.println(g);
            System.out.println(l);
        }
    }
    public static class permutation {
        public static boolean next_permutation(int[] a) {
            int i = a.length-1; //i를 최대 인덱스로 두고
            while(i>0 && a[i-1] >= a[i]) i-=1; //지금 인덱스 숫자가 1작은 인덱스보다 클떄까지
            if(i<=0) return false; // 0보다 작거나 같아지면 return false;
            int j = a.length-1;
            while(a[i-1] >= a[j]) j-=1;//지금 인덱스 숫자가 위에서 찾은 i 보다 1적은 칸 보다 클떄까지
            int temp = a[i-1]; //i - 1 : 1   ??
            a[i-1] = a[j];
            a[j] = temp; //이제 찾은두개를 바꿈
            j = a.length-1;
            while(i<j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i += 1;
                j -= 1;
            }
            return true;
        }

        public static boolean prev_permutation(int[] a) {
            int i = a.length-1;
            while(i>0 && a[i-1] <= a[i]) i-=1;
            if(i<=0) return false;
            int j = a.length-1;
            while(a[i-1] <= a[j]) j-=1; //방향만 다름 위에랑
            swap(a, i-1, j);//똑같은데 스왑을 썻을 때임
            j = a.length-1;
            while (i < j) {
                swap(a, i, j);
                i += 1;
                j -= 1;
            }
            return true;
        }

        static void swap(int[] a, int x, int y) {
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++) a[i] = sc.nextInt();

            Arrays.sort(a);//sort해주는 이유는 무작위로들어 왔을 경우이고 그게 아니면 안해줘도됩니
            System.out.println("바로 다음 순열");
            next_permutation(a);
            for (int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            System.out.println("바로 이전 순열");
            prev_permutation(a);
            for (int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            System.out.println("모든 순열");
            do {
                for(int i=0; i<n; i++) {
                    System.out.print(a[i]+" ");
                }
                System.out.println();
            } while(next_permutation(a));
        }
    }
}
