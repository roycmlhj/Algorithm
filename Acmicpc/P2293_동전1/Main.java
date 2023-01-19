package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n+1];
		int[] memo = new int[k + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		memo[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				memo[j] += memo[j-coin[i]];
			}
		}
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= k; j++) {
//				System.out.print(memo[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(memo[k]);
	}

}
