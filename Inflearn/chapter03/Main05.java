package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main05 {
	/*
	 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
	 * 
	 * 만약 N=15이면
	 * 
	 * 7+8=15
	 * 
	 * 4+5+6=15
	 * 
	 * 1+2+3+4+5=15 , 총 3가지 존재
	 * 
	 * 
	 * 
	 * 
	 */
	public static int N;
	public static int[] arr;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		// 로직
		int sum = 0;
		int lt = 1;
		for (int rt = 1; rt <= N; rt++) {
			sum += arr[rt];
			if(sum == N) {
				answer++;
			}
			while(sum >= N) {
				sum -= arr[lt];
				lt++;
				if(sum == N) {
					answer++;
				}
			}
		}
		// 출력
		System.out.print(answer-1);
	}

}
