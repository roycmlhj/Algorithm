package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < 1001; i++) {
			arr[i] = (arr[i-1]+arr[i-2])%10007;
		}
		System.out.println(arr[n]);
	}

}
