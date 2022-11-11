package chapter2;

public class 중복조합 {

	public static void main(String[] args) {
		//중복조합(Combination with competition) : 서로 다른 n개에서 중복이 가능하게 r개를 뽑기, (1,1)
		int[] arr = {1,2,3,4,5};
		int x = 2;
		combination(arr,x,new int[x],0,0);

	}

	private static void combination(int[] arr, int x, int[] v, int depth,int start) {
		if(depth == x) {
			for (int i = 0; i < v.length; i++) {
				System.out.print(v[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < arr.length; i++) {
			v[depth] = arr[i];
			combination(arr, x, v, depth+1,i);
		}
	}

}
