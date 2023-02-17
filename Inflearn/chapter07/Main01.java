package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01 {
	/*
	 * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력(스택프레임)
	 * */
	public static int N = 0;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		// 로직
		recursion(1);
		// 출력
		// System.out.print(answer);
	}

	private static void recursion(int num) {
		if (num == N) {
			System.out.print(N);
			return;
		}
		System.out.print(num + " ");
		recursion(num + 1);

	}

}
