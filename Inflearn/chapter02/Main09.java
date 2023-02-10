package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main09 {
	/*
	 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합,
	 * 
	 * 두 대각선의 합 중 가 장 큰 합을 출력
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < N; j++) {
				sum1 += map[i][j];
				sum2 += map[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		int sum3 = 0;
		int sum4 = 0;
		for (int i = 0; i < N; i++) {
			sum3 += map[i][i];
			sum4 += map[i][N - i - 1];
		}
		answer = Math.max(answer, sum3);
		answer = Math.max(answer, sum4);
		System.out.println(answer);
	}
}
