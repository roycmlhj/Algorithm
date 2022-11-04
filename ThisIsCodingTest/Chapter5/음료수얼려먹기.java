package chapter5;

import java.util.Scanner;

public class 음료수얼려먹기 {
	static int[][] map;
	static int N = 0;
	static int M = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		sc.nextLine(); // 버퍼 지우기
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dfs(i,j)) {
					answer += 1;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean dfs(int i, int j) {
		if(i<0 || j<0 || i >= N || j >=M) {
			return false;
		}
		if(map[i][j] == 0) {//방문하지 않았다면
			//방문처리 후 사방으로 dfs
			map[i][j] = 1;
			dfs(i-1,j);
			dfs(i,j+1);
			dfs(i+1,j);
			dfs(i,j-1);
			return true;
		}
		return false;
	}

}
