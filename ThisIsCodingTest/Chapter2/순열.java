package chapter2;

public class 순열 {

	public static void main(String[] args) {
		//순열(Permutation) : 서로 다른 n개에서 r개를 뽑아 정렬(순서가 있다) (1,1)불가능
		int[] arr = {1,2,3,4,5};
		int x = 2;
		permutation(arr,x,new int[x],new boolean[arr.length],0);

	}

	private static void permutation(int[] arr, int x, int[] is, boolean[] v, int depth) {
		if(depth == x) {
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				is[depth] = arr[i];
				permutation(arr, x, is, v, depth+1);
				v[i] = false;
			}
		}
	}

}
