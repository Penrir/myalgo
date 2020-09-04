import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DailyPractice0824 {
    public static void main(String[] args) {
        int size = 4;
//        Integer[] arr = new Integer[size];
//        Random random = new Random(System.currentTimeMillis());
//        for (int i = 0; i < size; i++) {
//            arr[i] = random.nextInt(20);
//        }
        Integer[] arr = {1, 2, 3};
        System.out.println("arr =           " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("sorted arr =    " + Arrays.toString(arr));
        System.out.println();
//        System.out.println("조합");
//        int r = 3;
//        comb(arr, 0, r, new int[r]);
//        System.out.println("중복조합");
//        reComb(arr, 0, r, new int[r]);
        System.out.println("SubSet");
        subset(arr);
        System.out.println("RecursiveSubset");
        subsetRecursive(arr, 0, 0,new Integer[arr.length]);
    }

    //순열
    public static void permutation(Integer[] arr){

    }
    //넥스트퍼뮤테이션
    public static Integer[] nextPermutation(Integer[] arr){
        //오름차순 끝나는 위치에서 가장 큰수랑
        return null;
    }
    //넥스트 퍼뮤에서 숫자가 커지다가 작아지기 시작하는 인덱스는 찾아주는 메소드
    public static int findBig(Integer[] arr){
        int before = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(before > arr[i]) return i;
            before = arr[i];
        }
        return arr.length;
    }

    //중복순열

    //조합        arr에서 r개 뽑는 조합.
    public static void comb(Integer[] arr, int idx, int r, int[] result){
        //다 뽑았으면 출력
        if(r == 0) {
            System.out.println(Arrays.toString(result));
            return ;
        }
        //모든 요소들을 넣고 안넣고 고려 했을 시 메소드 끝내기.
        if(idx == arr.length) return;
        //인덱스 번쨰 요소를 답안에 넣는다.
        result[result.length-r] = arr[idx];
        //리커시브하게 돈다. 추가 한 경우
        comb(arr, idx+1,r-1, result);
        //추가하지 않은 경우
        comb(arr, idx +1, r, result);
    }

    //중복조합
    public static void reComb(Integer[] arr, int idx, int r, int[] result){
        //다 뽑았으면 출력
        if(r == 0) {
            System.out.println(Arrays.toString(result));
            return ;
        }
        //모든 요소들을 넣고 안넣고 고려 했을 시 메소드 끝내기.
        if(idx == arr.length) return;
//        if(idx == result.length){
//            System.out.println(Arrays.toString(result));
//            return;
//        }
        for (int i = 0; i < result.length; i++) {
            result[idx] = arr[i];
            reComb(arr, idx+ 1, r-1, result);
        }
    }

    //부분집합
    public static void subset(Integer[] arr){
            //비트연산으로 부분집합
            System.out.println();
            for (int i = 0; i < (1 << arr.length); i++) {
                for (int idx = 0; idx < arr.length; idx++) {
                    if( ((1 << idx) & i)  != 0){
                        System.out.print(arr[idx] + " ");
                    }
//                    else{
//                        System.out.print(arr[idx]);
//                    }
//                    System.out.print(" ");
                }
                System.out.println();
            }
    }
    public static void subsetRecursive(Integer[] arr, int depth, int idx, Integer[] result){
        if (depth == arr.length){
//            result.forEach(s -> System.out.print(s + " "));
            System.out.println(Arrays.toString(result));
            return;
        }
        if(idx == arr.length) return;
        subsetRecursive(arr, depth+1, idx ,result);
        result[idx] = arr[depth];
        subsetRecursive(arr, depth+1, idx+1,result);
        result[idx] = null;
    }
}
