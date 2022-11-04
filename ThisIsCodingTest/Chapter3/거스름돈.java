package chapter3;

public class 거스름돈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1260;
		int answer = 0;
		int[] arr = {500,100,50,10};
		
		for (int i = 0; i < 4; i++) {
			int coin = arr[i];
			answer += N/coin;
			N %= coin;
		}
		
		System.out.println(answer);
		
	}

}
