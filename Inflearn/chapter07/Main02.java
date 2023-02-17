package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * 10진수 N이 입력되면 2진수로 변환하여 출력(재귀활용)
	 * */
	public static int N = 0;
	//public static String answer = "";

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		// 로직
		recursion(N);
		// 출력
		// System.out.print(answer);
	}

	private static void recursion(int num) {
		if (num == 0) {
			return;
		}else {
			recursion(num/2);			
			System.out.print(num%2);
		}

	}

}
