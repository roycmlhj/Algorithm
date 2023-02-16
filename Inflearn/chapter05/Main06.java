package chapter05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main06 {
	/*
	 * 공주 구하기
	 */
	public static int N,M;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 로직
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while(!queue.isEmpty()) {
			for (int i = 1; i < M; i++) {
				queue.offer(queue.poll());
			}
			queue.poll();
			if(queue.size()==1) {
				answer = queue.poll();
			}
		}
		// 출력
		System.out.println(answer);
	}

}
