package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12 {
	/*
	 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수 출력
	 *
	 * DFS 사용
	 */
	
	public static int N, M;
	public static int[] check;
	public static int[][] graph;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		check = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		// 로직
		// 경로탐색이니까 DFS
		check[1] = 1;
		dfs(1);
		// 출력
		System.out.print(answer);
	}

	private static void dfs(int v) {
		if (v == N) {
			answer++;
		} else {
			for (int i = 1; i <= N; i++) {
				if (graph[v][i] == 1 && check[i] == 0) {
					check[i] = 1;
					dfs(i);
					check[i] = 0;
				}
			}
		}

	}

}
