package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * N개의 수로 이루어진 수열이 주어집니다.
	 * 
	 * 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가
	 * 
	 * 몇 번 있는지 구하는 프로그램을 작성하세요.
	 * 
	 * 
	 */
	public static int N, M;
	public static int[] arr;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 로직
		int lt = 0;
		int sum = 0;
		for (int rt = 0; rt < N; rt++) {
			sum += arr[rt];
			if (sum == M) {
				answer++;
			}
			while (sum >= M) {
				sum -= arr[lt++];
				if (sum == M) {
					answer++;
				}
			}
		}
		// 출력
		System.out.print(answer);
	}

}
