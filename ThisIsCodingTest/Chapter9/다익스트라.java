package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라 {
	
	static class Node{
		private int i;
		private int d;
		public Node(int i, int d) {
			super();
			this.i = i;
			this.d = d;
		}
		public int getI() {
			return i;
		}
		public int getD() {
			return d;
		}
		
	}
	
	// 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
	// 노드의 개수는 최대 100,000개라고 가정
	static int n,m,start;
	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static boolean[] v = new boolean[100001];
	static int[] d = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			//a노드에서 b노드로 가는 비용이 c
			graph.get(a).add(new Node(b,c));
		}
		Arrays.fill(d, (int)1e9);
		//다익스트라 로직
		dijkstra(start);
		//최단거리 출력
		for (int i = 1; i <= n; i++) {
			if(d[i] == (int)1e9) {
				System.out.println("INF");
			}else {
				System.out.println(d[i]);
			}
		}
	}
	private static void dijkstra(int start) {
		d[start] = 0;
		v[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			d[graph.get(start).get(i).getI()] = graph.get(start).get(i).getD();
		}
		for (int i = 0; i < n-1; i++) {
			int now = getSmallestNode();
			v[now] = true;
			// 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getD();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getI()]) {
                    d[graph.get(now).get(j).getI()] = cost;
                }
            }
		}
		
	}
	private static int getSmallestNode() {
		int min_value = (int)1e9;
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if(d[i] < min_value && !v[i]) {
				min_value = d[i];
				index = i;
			}
		}
		return index;
	}

}
