package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * 1부터 N까지 번호가 붙은 구슬 존재
	 * 
	 * 중복 허락하여 M번을 뽑아 일렬로 나열
	 * 
	 * >DFS겠다
	 */
	public static int N, M;
	public static int[] arr;
	public static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		// 로직
		dfs(0);//level
		// 출력
		//System.out.print(answer);

	}
	private static void dfs(int level) {
		if(level == M) {
			for(int i:arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}else {
			for (int i = 1; i <= N; i++) {
				arr[level] = i;
				dfs(level+1);
			}
		}
	}

}
