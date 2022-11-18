package chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 도시분할계획 {
	static class Edge implements Comparable<Edge> {
		private int dist;
		private int nodeA;
		private int nodeB;

		public Edge(int dist, int nodeA, int nodeB) {
			this.dist = dist;
			this.nodeA = nodeA;
			this.nodeB = nodeB;
		}

		public int getDist() {
			return dist;
		}

		public int getNodeA() {
			return nodeA;
		}

		public int getNodeB() {
			return nodeB;
		}

		@Override
		public int compareTo(Edge other) {
			if(this.dist < other.dist) {
				return -1;
			}
			return 1;
		}

	}

	static int n,m;
	static ArrayList<Edge> graph = new ArrayList<Edge>();
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		//부모 테이블 초기화
		int[] parents = new int[n+1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		//정렬
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			graph.add(new Edge(cost,a,b));
		}
		Collections.sort(graph);
		//간선 확인 및 가장 큰 간선 확인
		int max = 0;
		for (int i = 0; i < graph.size(); i++) {
			int cost = graph.get(i).getDist();
			int a = graph.get(i).getNodeA();
			int b = graph.get(i).getNodeB();
			//사이클이 없을때만 경로에 저장
			if(find(a,parents) != find(b,parents)) {
				union(a,b,parents);
				answer += cost;
				max = cost;
			}
		}
		System.out.println(answer - max);
	}
	private static void union(int a, int b, int[] parents) {
		a = find(a,parents);
		b = find(b,parents);
		if(a < b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
		
	}
	private static int find(int a, int[] parents) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a],parents);
	}

}
