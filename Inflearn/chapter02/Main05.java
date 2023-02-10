package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main05 {
	/*
	 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
	 * 
	 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] arr = new int[N+1];
		for (int i = 2; i <= N; i++) {
			if(arr[i] == 0) {
				answer++;
				for (int j = i; j <= N; j=j+i) {
					arr[j] = 1;
				}
			}
		}
		System.out.println(answer);
	}

}
