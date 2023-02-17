package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main05 {
	/*
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
		dfs(root);
		//로직
		
		// 출력
		
	}
	private static void dfs(Node root) {
		if(root == null) {
			return;
		}else {
			//System.out.print(root.data+" ");//전위순회
			dfs(root.lt);
			System.out.print(root.data+" ");//중위순회
			dfs(root.rt);
		}
		
	}

}
