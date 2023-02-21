package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다.
	 * 
	 * 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
	 * 
	 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
	 * 
	 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면,
	 * 
	 * 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
	 * 
	 * 
	 */
	public static int C,N;
	public static int[] arr;
	public static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 로직
		dfs(0, 0);// level,sum
		// 출력
		System.out.print(answer);

	}

	private static void dfs(int level, int sum) {
		if(level == N) {
			if(sum < C) {
				answer = Math.max(answer, sum);				
			}
			return;
		}else {
			dfs(level+1,sum+arr[level]);
			dfs(level+1,sum);
		}
		
	}


}
