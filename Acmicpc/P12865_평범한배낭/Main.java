package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] W = new int[n + 1];
		int[] V = new int[n + 1];
		int[][] memo = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (W[i] > j) {
					memo[i][j] = memo[i - 1][j];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - W[i]] + V[i]);
				}
			}
		}
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= k; j++) {
//				System.out.print(memo[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(memo[n][k]);
	}

}
