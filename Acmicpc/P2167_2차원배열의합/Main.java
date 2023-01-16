package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2167 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][m + 1];
		for (int c = 1; c <= n; c++) {
			st = new StringTokenizer(br.readLine());
			for (int d = 1; d <= m; d++) {
				arr[c][d] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for (int f = 0; f < k; f++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int l = i; l <= x; l++) {
				for (int l2 = j; l2 <= y; l2++) {
					sum += arr[l][l2];
				}
			}
			System.out.println(sum);
		}
	}
}
