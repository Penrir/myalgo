import java.util.Arrays;

public class DailyPractice0830 {
		static int[] arr = {1, 2, 3};
		static int n = arr.length;
		static int r = 2;
    public static void main(String[] args) {
//    	permutationUseSwap(0, n, r);
//    	System.out.println();
//    	permutationUseVisited(new boolean[arr.length], 0, n, r, new int[arr.length]);
    	System.out.println();
    	combination(new int[r], 0, 0);
    }
    public static void permutationUseSwap(int depth, int n , int r){
    		if(depth == r) {
    			printArr(0, depth);
    			return;
    		}
    		for (int i = depth; i < arr.length; i++) {
    			SWAP(depth, i);
    			permutationUseSwap(depth+1, n, r);
    			SWAP(depth, i);
				}
    }
    
    public static void permutationUseVisited(boolean[] visited, Integer depth, int n, int r, int[] result) {
    	if(depth == r) {
    		for (int i = 0; i < r; i++) {
					System.out.print(result[i]+ " " );
				}
    		System.out.println();
    		return;
    	}
    	for (int i = 0; i < n; i++) {
    		if(!visited[i]) {
    			visited[i] = true; 
    			result[depth] = arr[i];
    			permutationUseVisited(visited, depth+1, n, r, result);
    			visited[i] = false; 
    		}
			}
    }
    
    public static void combination(int[] result, int idx, int depth){
    	if(depth == result.length) {
//    		printArr(result, idx);
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	if(idx == arr.length) return;
    	result[depth]= arr[idx];
    	combination(result, idx+1, depth+1);
    	combination(result, idx+1, depth);
    }
    
    public static void subset(int[] result, int idx, int depth){
        
    }
    
    public static void subsetBit(int[] result, int idx, int r) {
    	
    }
    
    public static int gcd(int a, int b) {
    	while(b!=0) {
    		int r = a%b;
    		a = b;
    		b = r;
    	}
    	return a;
    	/*
				최대공약수 공식(유클리드 호제법)
				a,b: 최대공약수를 구하고자 하는 두 수
				r: a를 b로 나눈 나머지 = ( a%b ) = ( a mod b )
				식: gcd(a,b) = gcd(b,r)
    	*/
    }
    public static int lcm(int a, int b) {
    	/*
    	 최소공배수 공식(최대공약수를 이용)
			a,b: 최소공배수를 구하고자 하는 두 수
			gcd(a,b): a와b의 최대공약수
			(최소공배수 * 최대공약수 = a * b)를 이용
			식: a * b / gcd(a,b)
    	 */
    	return a*b / gcd(a, b);
    }
    
    
    public static void printArr(int[] arr, int end) {
    	for (int i = 0; i < end; i++) {
				System.out.print(arr[i] + " ");
			}
    	System.out.println();
    }
    public static void printArr(int start, int end) {
    	for (int i = start; i < end; i++) {
				System.out.print(arr[i] + " ");
			}
    	System.out.println();
    }
    public static void SWAP(int s, int e) {
    	int temp = arr[s];
    	arr[s]= arr[e]; 
    	arr[e]= temp; 
    }
}
