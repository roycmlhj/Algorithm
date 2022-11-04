package chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {
	static int N = 0;
	static int M = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		sc.nextLine(); // 버퍼비우기
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}

		}
		
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(i,j));
		while(!q.isEmpty()) {
			Node nowNode = q.poll();
			int x = nowNode.getX();
			int y = nowNode.getY();
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y+dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {//범위를 벗어난 경우 그냥 진행
					continue;
				}
				if(map[nx][ny]==0) { //몬스터도 그냥 진행
					continue;
				}
				if(map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
			
		}
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}
}
