package chapter05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * 
	 * 
	 */
	public static int N,M;
	public static int[][] board;
	public static int[] moves;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		moves = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}	
		// 로직
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < M; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				if(board[j][moves[i]-1]==0) {
					continue;
				}else {
					temp = board[j][moves[i]-1];
					board[j][moves[i]-1] = 0;
					break;
				}
			}
			//System.out.println("temp: "+temp);
			if(temp!=0) {//넣을 수 있는 값
				if(!stack.isEmpty() && stack.peek()==temp) {//스택이 비어 있지 않고 탑이 같다
					answer++;
					answer++;
					stack.pop();
				}else {
					stack.push(temp);					
				}
			}
		}
		
		// 출력
		System.out.println(answer);
	}

}
