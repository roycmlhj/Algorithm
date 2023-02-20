package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14 {
	/*
	 * 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력
	 */
//6 9
//1 3
//1 4
//2 1
//2 5
//3 4
//4 5
//4 6
//6 2
//6 5
	public static int N, M;
	public static int[] check;
	public static int[] dis;
	public static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<Integer>>();
		check = new int[N + 1];
		dis = new int[N + 1];
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
		bfs(1);
		// 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(i + " : " + dis[i]);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		check[v] = 1;
		dis[v] = 0;
		queue.offer(v);
		while (!queue.isEmpty()) {
			int cv = queue.poll();
			for (int nv : graph.get(cv)) {
				if(check[nv] == 0) {
					check[nv] = 1;
					queue.offer(nv);
					dis[nv] = dis[cv]+1;
				}
			}
		}
	}

}
