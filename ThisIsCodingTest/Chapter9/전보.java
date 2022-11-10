package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {
	static class Node implements Comparable<Node>{
		private int index;
		private int dist;
		
		public Node(int index, int dist) {
			super();
			this.index = index;
			this.dist = dist;
		}
		

		public int getIndex() {
			return index;
		}


		public void setIndex(int index) {
			this.index = index;
		}


		public int getDist() {
			return dist;
		}


		public void setDist(int dist) {
			this.dist = dist;
		}


		@Override
		public int compareTo(Node other) {
			if(this.dist < other.dist) {
				return -1;
			}
			return 1;
		}
		
	}
	
	static int n,m,start;
	static int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//도시 개수, 통로 개수, 보내고자하는 도시
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		map = new int[n+1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			graph.get(x).add(new Node(y,z));
		}
		Arrays.fill(map, INF);
		
		//다익스트라
		dijkstra(start);
		
        int count = 0;
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (map[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, map[i]);
            }
        }

        System.out.println((count - 1) + " " + maxDistance);

	}
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		map[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDist();
			int now = node.getIndex();
			//이미 처리된 노드
			if(map[now] < dist) {
				continue;
			}
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = map[now] + graph.get(now).get(i).getDist();
				if (cost < map[graph.get(now).get(i).getIndex()]) {
                    map[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
			}
			
		}
		
	}

}
