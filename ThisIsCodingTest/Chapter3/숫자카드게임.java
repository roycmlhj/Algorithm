package chapter3;

import java.util.Scanner;

public class 숫자카드게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res = 0;
		
		for (int i = 0; i < N; i++) {
			int min = 101;
			for (int j = 0; j < M; j++) {
				int temp = sc.nextInt();
				min = Math.min(temp, min);
			}
			res = Math.max(min, res);
		}
		
		System.out.println(res);
		
		
	}

}
