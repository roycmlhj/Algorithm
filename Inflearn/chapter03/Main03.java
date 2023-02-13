package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라
	 *
	 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
	 *
	 * 12 15 11 20 25 10 20 19 13 15 > 연속된 3일간의 최대 매출액은 11+20+25=56만원
	 * 
	 */
	public static int N, M;
	public static int[] arr;
	public static int max = Integer.MIN_VALUE;
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
		for (int i = 0; i <= N - M; i++) {
			int sum = 0;
			for (int j = i; j < i+M; j++) {
				sum += arr[j];
			}
			//System.out.println(i + ": "+sum);
			max = Math.max(sum, max);

		}
		System.out.print(max);
	}

}
