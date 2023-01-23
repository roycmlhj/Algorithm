package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15685 {
	public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int N;
    public static int answer=0;
    public static boolean[][] map = new boolean[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon(x,y,d,g);
		}
		for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer+=1;
                }
            }
        }
		System.out.println(answer);
	}
	private static void dragon(int x, int y, int d, int g) {
		LinkedList<Integer> arr = new LinkedList<>();
		arr.add(d);
		for (int i = 1; i <= g; i++) {
            for (int j = arr.size() - 1; j >= 0; j--) {
                arr.add((arr.get(j) + 1) % 4);
            }
        }
		map[y][x] = true;
		for (int i = 0; i < arr.size(); i++) {
			x += dx[arr.get(i)];
            y += dy[arr.get(i)];
            map[y][x] = true;
		}
	}
}
