package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Player {
	int num, x, y, d, s, a;

	public Player(int num, int x, int y, int d, int s, int a) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.d = d;
		this.s = s;
		this.a = a;
	}

}

public class Main_싸움땅 {
	public static int n, m, k;
	public static ArrayList<Integer>[][] gun = new ArrayList[20][20];
	public static Player[] players = new Player[30];
	public static int[] dx = new int[] { -1, 0, 1, 0 }; // 상 우 하 좌
	public static int[] dy = new int[] { 0, 1, 0, -1 };
	public static final Player EMPTY = new Player(-1, -1, -1, -1, -1, -1);
	public static int[] points = new int[30];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // map 크기
		m = Integer.parseInt(st.nextToken()); // 플레이어 수
		k = Integer.parseInt(st.nextToken()); // 라운드 수
		int[][] map = new int[n][n];
		// 총 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				gun[i][j] = new ArrayList<>();
				int temp = Integer.parseInt(st.nextToken());
				if (temp != 0) {// 총이다
					gun[i][j].add(temp); // 해당 격자의 총 리스트에 저장
				}
			}
		}
		// 플레이어 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x 좌표
			int y = Integer.parseInt(st.nextToken()); // y 좌표
			int d = Integer.parseInt(st.nextToken()); // 방향
			int s = Integer.parseInt(st.nextToken()); // 초기 능력치
			players[i] = new Player(i, x - 1, y - 1, d, s, 0);
		}
		System.out.print(n + " " + m + " " +k);
		// 시뮬레이션
		for (int i = 0; i < k; i++) {
			simulate();
		}
		// 출력
		for (int i = 0; i < m; i++) {
			System.out.print(points[i] + " ");
		}
	}

	private static void simulate() {
		for (int i = 0; i < m; i++) {
			int num = players[i].num;
			int x = players[i].x;
			int y = players[i].y;
			int d = players[i].d;
			int s = players[i].s;
			int a = players[i].a;

			// 움직일 방향 정함
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx <= 0 || ny <= 0 || nx >= n || ny >= n) {// 범위를 벗어남
				d ^= 2;
				nx = x + dx[d];
				ny = y + dy[d];
			}
			// 좌표 업데이트
			Player currPlayer = new Player(num, nx, ny, d, s, a);
			update(currPlayer);

			// 해당 위치에 플레이어가 있는지 확인
			Player otherPlayer = find(nx, ny);

			if (otherPlayer == EMPTY) {// 사람 안 마주침
				move(currPlayer, nx, ny);
			} else {// 결투
				fight(currPlayer, otherPlayer, nx, ny);
			}
		}

	}

	private static void fight(Player cp, Player op, int nx, int ny) {
		int num1 = cp.num, d1 = cp.d, s1 = cp.s, a1 = cp.a;
		int num2 = op.num, d2 = op.d, s2 = op.s, a2 = op.a;

		// cp가 이김
		if (((s1 + a1) > (s2 + a2)) || ((s1+a1 == s2+a2) && (s1 > s2))) {
			points[num1] += (s1+a1)-(s2+a2);
			loserMove(op);
			move(op,nx,ny);
		}else {// op가 이김
			points[num2] += (s2 + a2) - (s1 + a1);
            loserMove(cp);
            move(cp, nx,ny);
		}
	}

	private static void loserMove(Player p) {
		int num = p.num, x = p.x, y = p.y, d = p.d, s = p.s, a = p.a;
		//총 내려놔
		gun[x][y].add(a);
		for (int i = 0; i < 4; i++) {
			int dir = (d+i)%4;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if((nx > 0 || ny > 0 || nx < n || ny < n) && find(nx,ny) == EMPTY) {
				p = new Player(num, x, y, dir, s, 0);
				move(p, nx, ny);
				break;
			}
		}
		
	}

	private static void move(Player p, int nx, int ny) {
		int num = p.num;
		int x = p.x;
		int y = p.y;
		int d = p.d;
		int s = p.s;
		int a = p.a;
		// 현재 좌표에 총을 내려놓음
		gun[nx][ny].add(a);
		// 해당 좌표 정렬
		Collections.sort(gun[nx][ny]);
		// 가장 큰 공격력의 총으로 갱신하고 제거
		a = gun[nx][ny].get(gun[nx][ny].size() - 1);
		gun[nx][ny].remove(gun[nx][ny].size() - 1);
		// 새로운 총을 가진 객체로 업데이트
		p = new Player(num, nx, ny, d, s, a);
		update(p);
	}

	private static void update(Player cp) {
		int num = cp.num;
		for (int i = 0; i < m; i++) {
			int temp = players[i].num;
			if (num == temp) {
				players[i] = cp;
				break;
			}
		}

	}

	private static Player find(int nx, int ny) {
		for (int i = 0; i < m; i++) {
			int x = players[i].x;
			int y = players[i].y;
			if (nx == x && ny == y) { // 좌표가 같으면 같은 위치,only 한명만 같은 위치가 될 수 있다.
				return players[i];
			}
		}
		return EMPTY;
	}

}
