package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드워셜 {

	public static final int INF = (int) 1e9;
    // 노드의 개수(N), 간선의 개수(M), 노드의 개수는 최대 500개
    public static int n, m;
    public static int[][] graph = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		//배열을 전부 무한으로 초기화
		for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }
		//자기 자신은 0으로
		for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }
		for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }
		
		//플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
	}

}
