package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11 {
	/*
	 * 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 
	 * 
	 * 임시 반장을 정하라
	 */
	public static int N;
	public static int[][] map;
	public static int answer=0;
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][6];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 6; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				for (int j2 = 1; j2 <= 5; j2++) {
					if(map[i][j2] == map[j][j2]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt>max) {
				max = cnt;
				answer = i;
			}
		}
		
		System.out.print(answer);
	}
}
