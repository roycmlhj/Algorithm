package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086 {
	public static int n;
	public static int[] dx = { 1,0,-1,0 };
	public static int[] dy = { 0,1,0,-1 };
	public static int[][] map;
	public static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		//v = new boolean[n][n];
		int answer = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
			}
		}
		//로직
		for (int i = 1; i <= max; i++) {//높이만큼 반복
			v = new boolean[n][n];
			int temp = 0;
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(!v[j][j2] && map[j][j2]>=i) {
						dfs(i,j,j2);
						temp++;
					}
				}
			}
			answer = Math.max(answer, temp);
		}
		//출력
		System.out.println(answer);
	}
	private static void dfs(int height, int x, int y) {
		v[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
				continue;
			}
			if (!v[nx][ny] && map[nx][ny] >= height) {
				v[nx][ny] = true;
				dfs(height, nx, ny);
			}
		}
		
	}
	
}
