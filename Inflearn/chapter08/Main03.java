package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * 현수는 N개의 문제를 풀려고 합니다.
	 * 
	 * 각 문제는 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
	 * 
	 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
	 * 
	 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
	 */
	public static int N, M;
	public static int[][] arr;
	public static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 로직
		dfs(0, 0,0);// level,score,time
		// 출력
		System.out.print(answer);

	}

	private static void dfs(int level,int score, int sum) {
		if(sum > M) {
			return;
		}
		if(level == N) {
			answer = Math.max(answer, score);
		}else {
			dfs(level+1,score+arr[level][0],sum+arr[level][1]);
			dfs(level+1,score,sum);
		}
		
	}


}
