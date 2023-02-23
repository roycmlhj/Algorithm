package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11 {
	/*
	 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력
	 * 
	 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
	 * 
	 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다.
	 * 
	 * 격자판의 1은 벽이고, 0은 도로이다.
	 * 
	 * 격자판의 움직임은 상하좌우로만 움직인다.
	 * 
	 * 
	 */
	// public static int n, m;
	public static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[][] map = new int[8][8];
	public static int[][] dis = new int[8][8];
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
		bfs(1, 1);// x,y
		// 출력
		if (dis[7][7] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[7][7]);
		}

	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] temp = { i, j };
		queue.offer(temp);
		map[i][j] = 1;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				if (isIn(nx, ny) && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					int[] t = {nx,ny};
					queue.offer(t);
					dis[nx][ny] = dis[now[0]][now[1]]+1;
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
