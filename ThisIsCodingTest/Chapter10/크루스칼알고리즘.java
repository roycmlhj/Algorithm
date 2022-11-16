package chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 크루스칼알고리즘 {

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

		public void setDist(int dist) {
			this.dist = dist;
		}

		public int getNodeA() {
			return nodeA;
		}

		public void setNodeA(int nodeA) {
			this.nodeA = nodeA;
		}

		public int getNodeB() {
			return nodeB;
		}

		public void setNodeB(int nodeB) {
			this.nodeB = nodeB;
		}

		@Override
		public int compareTo(Edge other) {
			//상대의 거리가 더 크면 음수 반환(높은 우선순위)
			if(this.dist < other.dist) {
				return -1;
			}
			return 1;
		}

	}

	// 노드 수 : v, 간선 수 : e
	static int v, e;
	static int[] parents = new int[100001]; //부모 테이블
	static ArrayList<Edge> graph = new ArrayList<Edge>();
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();

		// 부모테이블에서 부모를 자기 자신으로
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}

		// union
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			graph.add(new Edge(cost,a,b));
		}
		
		//크루스칼은 최소 비용 간선을 사이클 없이 연결하니까 정렬한다.
		Collections.sort(graph);
		
		for (int i = 0; i < graph.size(); i++) {
			int cost = graph.get(i).getDist();
			int a = graph.get(i).getNodeA();
			int b = graph.get(i).getNodeB();
			//사이클이 발생하지 않은 경우에만 정답 경로에 포함
			if(find(a) != find(b)) {
				union(a,b);
				answer += cost;
			}
		}
		
		System.out.print(answer);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
	}

	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

}
