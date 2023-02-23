package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12 {
	/*
	 * 백준 - 토마토
	 * 
	 * 
	 */
	public static int n, m;
	public static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[][] map;
	public static int[][] dis;
	public static int answer = Integer.MIN_VALUE;
	public static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dis = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					int[] t = { i, j };
					queue.offer(t);
				}
			}
		}
		// 로직
		if (queue.size() == 0) {
			System.out.println(-1);
			return;
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				if (isIn(nx, ny) && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					int[] t = { nx, ny };
					queue.offer(t);
					dis[nx][ny] = dis[now[0]][now[1]] + 1;
				}
			}

		}
		// 출력
		boolean flag=true;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(map[i][j]==0) flag=false;
			}
		}
		if(flag){
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					answer=Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		}
		else System.out.println(-1);
	}

	private static boolean isIn(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx <m && ny <n) {
			return true;
		}
		return false;
	}

}
