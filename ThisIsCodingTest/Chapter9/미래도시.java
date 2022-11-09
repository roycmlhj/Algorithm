package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class 미래도시 {
	static int INF = (int)1e9;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		//map 초기화
		for (int i = 0; i <= n; i++) {
			Arrays.fill(map[i], INF);
		}
		//자기자신 비용 0
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == j) {
					map[i][j] = 0;
				}
			}
		}
		//간선비용
		for (int i = 0; i < m; i++) {
			//a : 출발 노드, b : 도착 노드
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		int x = sc.nextInt();
		int k = sc.nextInt();
		//플로이드워셜
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int j2 = 1; j2 <= n; j2++) {
					map[j][j2] = Math.min(map[j][j2],map[j][i] + map[i][j2]);
				}
			}
		}
		//결과
		int dist = map[1][k] + map[k][x];	
		//출력
		if(dist >= INF) {
			System.out.println(-1);
		}else {
			System.out.println(dist);
		}
	}

}
