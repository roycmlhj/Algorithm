package chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsexample {
	static boolean[] v = new boolean[9];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);

	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		v[i] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.println(temp);
			for (int j = 0; j < graph.get(temp).size(); j++) {
				int temp2 = graph.get(temp).get(j);
				if(!v[temp2]) {
					q.offer(temp2);
					v[temp2] = true;
				}
			}
		}
		
	}

}
