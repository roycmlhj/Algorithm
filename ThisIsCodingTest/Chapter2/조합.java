package chapter2;

public class 조합 {

	public static void main(String[] args) {
		//조합(Combination) : 서로 다른 n개에서 순서 없이 r개를 뽑기, (1,2)와(2,1)은 같다
		int[] arr = {1,2,3,4,5};
		int x = 2;
		combination(arr,x,new boolean[arr.length],0,0);

	}

	private static void combination(int[] arr, int x, boolean[] v, int depth,int start) {
		if(depth == x) {
			for (int i = 0; i < arr.length; i++) {
				if(v[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				combination(arr, x, v, depth+1,i+1);
				v[i] = false;
			}
		}
	}

}
