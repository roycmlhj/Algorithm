import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static int n,m;
	public static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					int temp = bfs(i,j);
					if(temp > answer) {
						answer = temp;
					}else {
						answer = answer;
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static int bfs(int i, int j) {
		boolean[][] v = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		v[i][j] = true;
		queue.add(new int[] {i,j,0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 8; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				int dist = now[2];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {//범위 벗어남
					continue;
				}
				if (v[nx][ny] == true) {//방문한 곳 제외
					continue;
				}
				if(map[nx][ny] == 1) {
					return dist+1;
				}
				v[nx][ny] = true;
				queue.add(new int[] {nx,ny,dist+1});
			}
		}
		return 0;
	}

}
