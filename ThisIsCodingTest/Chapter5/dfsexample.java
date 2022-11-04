package chapter5;

import java.util.ArrayList;

public class dfsexample {
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

        dfs(1);

	}

	private static void dfs(int i) {
		v[i] = true;
		System.out.println(i);
		for (int j = 0; j < graph.get(i).size(); j++) {
			int temp = graph.get(i).get(j);
			if(!v[temp]) {
				dfs(temp);
			}
			
		}
		
	}

}
