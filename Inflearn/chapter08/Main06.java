package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
	/*
	 * 순열 구하기
	 * 
	 * 10이하 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법 모두 출력
	 */
	public static int N,M;
	public static int[] arr;
	public static int[] check;
	public static int[] answer;
	//public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		check = new int[N];
		answer = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 로직
		dfs(0);// level
		// 출력
		//System.out.print(answer);

	}

	private static void dfs(int level) {
		if(level == M) {
			for(int i : answer) {
				System.out.print(i+" ");
			}
			System.out.println();
		}else {
			for (int i = 0; i < N; i++) {
				if(check[i] == 0) {
					check[i] = 1;
					answer[level] = arr[i];
					dfs(level+1);
					check[i] = 0;
				}
			}
		}
	}

}
