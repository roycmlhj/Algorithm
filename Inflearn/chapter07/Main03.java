package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * 자연수 N이 입력되면 N!를 출력
	 * 
	 * ex) 5! = 5*4*3*2*1=120
	 * */
	public static int N = 0;
	public static int answer = 1;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		// 로직
		recursion(N);
		// 출력
		System.out.print(answer);
	}

	private static void recursion(int num) {
		if (num == 1) {
			return;
		}else {
			recursion(num-1);			
			answer *= num;
		}
	}

}
