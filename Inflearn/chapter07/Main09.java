package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main09 {
	/*
	 * DFS로 말단노드까지의 가장 짧은 경로
	 */
	static class Node {
		int data;
		Node lt, rt;

		public Node(int val) {
			data = val;
			lt = null;
			rt = null;
		}
	}

	public static Node root;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		root = new Node(1);
		root.lt = new Node(2);
		root.rt = new Node(3);
		root.lt.lt = new Node(4);
		root.lt.rt = new Node(5);
		// 로직
		answer = dfs(0, root);
		// 출력
		System.out.print(answer);
	}

	private static int dfs(int level,Node root) {
		if(root.lt == null && root.rt==null) {
			return level;
		}else {
			return Math.min(dfs(level+1,root.lt), dfs((level+1),root.rt));
		}
	}
}
