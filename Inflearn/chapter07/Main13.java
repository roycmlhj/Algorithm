package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13 {
	/*
	 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수 출력
	 *
	 * 인접리스트 사용
	 */
//	5 9
//	1 2
//	1 3
//	1 4
//	2 1
//	2 3
//	2 5
//	3 4
//	4 2
//	4 5
	public static int N, M;
	public static int[] check;
	public static ArrayList<ArrayList<Integer>> graph;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<Integer>>();
		check = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		// 로직
		// 경로탐색이니까 DFS
		check[1] = 1;
		dfs(1);
		// 출력
		System.out.print(answer);
	}

	private static void dfs(int v) {
		if(v == N) {
			answer++;
		}else {
			for(int nv:graph.get(v)) {
				if(check[nv] == 0) {
					check[nv] = 1;
					dfs(nv);
					check[nv] = 0;
				}
			}
		}
	}

}
