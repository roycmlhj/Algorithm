package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
	/*
	 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
	 * 
	 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다.
	 * 
	 * 격자판의 1은 벽이고, 0은 통로이다.
	 * 
	 * 
	 */
	// public static int n, m;
	public static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[][] map = new int[8][8];
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 7; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		map[1][1] = 1;
		dfs(1, 1);// x,y
		// 출력
		System.out.print(answer);

	}

	private static void dfs(int x, int y) {
		if (x == 7 && y == 7) {
			answer++;
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isIn(nx, ny) && map[nx][ny] == 0) {// 범위 안
					map[nx][ny] = 1;
					dfs(nx, ny);
					map[nx][ny] = 0;
				}
			}
		}

	}

	private static boolean isIn(int nx, int ny) {
		if (nx > 0 && ny > 0 && nx <= 7 && ny <= 7) {
			return true;
		}
		return false;
	}

}
