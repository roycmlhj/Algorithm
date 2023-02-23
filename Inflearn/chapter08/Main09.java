package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main09 {
	/*
	 * 조합 구하기
	 * 
	 * 1부터 N까지 번호가 적힌 구슬이 있음
	 * 
	 * 이 중 M개를 뽑는 방법의 수 출력
	 */
	public static int n,m;
	public static int[] combi;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		combi = new int[m];
		// 로직
		dfs(0, 1);// level,start
		// 출력
		//System.out.print(answer);

	}

	private static void dfs(int l, int s) {
		if(l==m) {
			for(int x:combi) {
				System.out.print(x+" ");
			}
			System.out.println();
		}else {
			for (int i = s; i <= n; i++) {
				combi[l] = i;
				dfs(l+1,i+1);
			}
		}
		
	}


}
