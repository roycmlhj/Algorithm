package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08 {
	/*
	 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다.
	 * 
	 * 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
	 * 
	 * 3 1 2 4
	 * 
	 * 4 3 6
	 * 
	 * 7 9
	 * 
	 * 16
	 * 
	 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
	 * 
	 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
	 * 
	 * 
	 */
	public static int n,f;
	public static int[][] dy = new int[35][35];
	public static int[] b,p,ch;
	public static boolean flag=false;
	// public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		b = new int[n];//b
		p = new int[n];//p
		ch = new int[n + 1];
		for (int i = 0; i < n; i++) {
			b[i] = combi(n-1,i);
		}
		// 로직
		dfs(0, 0);// level,sum
		// 출력
		//System.out.print(answer);

	}

	private static int combi(int n, int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n==r || r==0) {
			return 1;
		}else {
			return dy[n][r] = combi(n-1,r-1) + combi(n-1,r);
		}

	}

	private static void dfs(int L, int sum) {
		if(flag) return;
		if(L==n){
			if(sum==f){
				for(int x : p) System.out.print(x+" ");
				flag=true;
			}
		}
		else{
			for(int i=1; i<=n; i++){
				if(ch[i]==0){
					ch[i]=1;
					p[L]=i;
					dfs(L+1, sum+(p[L]*b[L]));
					ch[i]=0;
				}
			}
		}
	}

}
