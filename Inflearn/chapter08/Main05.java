package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main05 {
	/*
	 * 여러 단위의 동전들이 주어져 있을때 
	 * 
	 * 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
	 * 
	 * 각 단위의 동전은 무한정 쓸 수 있다.
	 */
	public static int N,M;
	public static int[] arr;
	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		// 로직
		dfs(0,0);// level(cnt),sum
		// 출력
		System.out.print(answer);

	}

	private static void dfs(int level,int sum) {
		if(sum > M) {
			return;
		}
		if(level >= answer) {
			return;
		}
		if (sum == M) {
			answer = Math.min(answer, level);
		} else {
			for (int i = 0; i < N; i++) {
				dfs(level+1,sum+arr[i]);
			}
		}
	}

}
