package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
	/*
	 * 조합의 경우수
	 * 
	 * nCr = n! / (n-r)!r!로 계산한다.
	 * 
	 * 해당 공식을 사용하지 않고 nCr = n-1Cr-1 + n-1Cr로 재귀를 이용해 조합수를 구하라
	 */
	public static int N,R;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		// 로직
		answer = dfs(N,R);// level
		// 출력
		System.out.print(answer);

	}

	private static int dfs(int n, int r) {
		if(n==r || r==0) {
			return 1;
		}else {
			return dfs(n-1,r-1)+dfs(n-1,r);
		}
	}

}
