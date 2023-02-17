package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
	/*
	 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합 출력
	 */
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		// 로직
		dfs(1);
		// 출력
	}

	private static void dfs(int l) {
		if (l == N + 1) {
			String temp = "";
			for (int i = 1; i <= N; i++) {  
				if (arr[i] == 1) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
			
			return;
		} else {
			arr[l] = 1;
			dfs(l + 1);// 왼쪽(사용함)
			arr[l] = 0;
			dfs(l + 1);// 오른쪽(사용안함)
		}

	}

}
