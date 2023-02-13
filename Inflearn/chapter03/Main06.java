package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main06 {
	/*
	 * 0과 1로 구성된 길이가 N인 수열이 주어집니다
	 * 
	 * 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
	 * 
	 * 최대 k번의 변경을 통해 1로만 구성된 최대 길이의 연속부분수열을 찾아라
	 * 
	 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
	 * 
	 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
	 * 
	 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
	 * 
	 * 1 1 0 0 (1 1 1 1 1 1 1 1)이며 그 길이는 8이다.
	 */
	public static int N, M;
	public static int[] arr;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			;
		}
		// 로직
		int lt = 0;
		int cnt = 0;
		for (int rt = 0; rt < N; rt++) {
			if (arr[rt] == 0) {
				cnt++;
			}
			while (cnt > M) {
				if (arr[lt] == 0) {
					cnt--;
				}
				lt++;
			}
			answer = Math.max(answer, rt - lt + 1);
		}

		// 출력
		System.out.print(answer);
	}

}
