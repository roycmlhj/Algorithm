package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07 {
	/*
	 * BFS
	 * */
	static class Node{
		int data;
		Node lt,rt;
		public Node(int val) {
			data = val;
			lt = null;
			rt = null;
		}
	}
	public static Node root;
	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		root = new Node(1);
		root.lt = new Node(2);
		root.rt = new Node(3);
		root.lt.lt = new Node(4);
		root.lt.rt = new Node(5);
		root.rt.lt = new Node(6);
		root.rt.rt = new Node(7);
		bfs(root);
		//로직
		
		// 출력
		
	}
	private static void bfs(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int len = queue.size();
			System.out.print(level+" : ");
			for (int i = 0; i < len; i++) {
				Node cur = queue.poll();
				System.out.print(cur.data+" ");
				if(cur.lt != null) {
					queue.offer(cur.lt);
				}
				if(cur.rt != null) {
					queue.offer(cur.rt);
				}
			}
			level++;
			System.out.println();
		}
	}

}
