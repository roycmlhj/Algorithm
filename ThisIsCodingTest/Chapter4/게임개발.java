package chapter4;

import java.util.Scanner;

public class 게임개발 {
	// 좌하우상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int dir=0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][] v = new boolean[N][M];
		int x = sc.nextInt();
		int y = sc.nextInt();
		v[x][y] = true;
		dir = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int answer = 1;
		int turn = 0;
		while (true) {
			// 왼쪽에 칸이 존재하는지 확인 후 있으면 이동
			turn_left();
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (v[nx][ny] == false && map[nx][ny] == 0) {// 안가봤고 육지
				v[nx][ny] = true;
				x = nx;
				y = ny;
				answer += 1;
				turn = 0;
				continue;
			} else {
				turn += 1;
			}
				
			if (turn == 4) {
				nx = x - dx[dir];
				ny = y - dy[dir];
				if (map[nx][ny] == 0) {
					x = nx;
					y = ny;
				} else {
					break;
				}
				turn = 0;
			}
		}
		System.out.println(answer);


	}

	private static void turn_left() {
		dir -= 1;
		if (dir == -1) {
			dir = 3;
		}
	}

}
