package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main10 {
	/*
	 * 지도 정보가 N*N 격자판에 주어집니다.
	 * 
	 * 각 격자에는 그 지역의 높이가 쓰여있습니다.
	 * 
	 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
	 * 
	 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
	 * 
	 * 
	 */
	public static int N;
	public static int[][] map;
	public static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if((map[i-1][j] < map[i][j]) && (map[i+1][j] < map[i][j]) && (map[i][j-1] < map[i][j]) && (map[i][j+1] < map[i][j])) {
					answer++;
					//System.out.println(i+" " +j +": "+map[i][j]);
				}
			}
		}
		System.out.print(answer);
	}
}
