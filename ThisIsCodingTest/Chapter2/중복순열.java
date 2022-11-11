package chapter2;

public class 중복순열 {

	public static void main(String[] args) {
		//중복순열(Permutation with reprtition) : 서로 다른 n개에서 중복이 가능하게 r개를 뽑아 정렬(순서가 있다), (1,1)가능
		//순열에서 방문 코드만 지우면 됨
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
			is[depth] = arr[i];
			permutation(arr, x, is, v, depth+1);
		}
	}

}
