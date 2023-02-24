package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13 {
	/*
	 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
	 * 
	 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
	 * 
	 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
	 * 
	 */
	public static int n;
	public static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[][] map;
	public static int[][] dis;
	public static int last = 0;
	public static int answer = 0;
	public static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		dis = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					answer++;
					bfs(i,j);
				}
			}
		}
		// 출력
		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] t = { x, y };
		queue.offer(t);
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(isIn(nx,ny) && map[nx][ny]==1) {
					int[] tt = {nx,ny};
					queue.offer(tt);
					map[nx][ny] = 0;
				}
			}
		}
	}

	private static boolean isIn(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
			return true;
		}
		return false;
	}

}
