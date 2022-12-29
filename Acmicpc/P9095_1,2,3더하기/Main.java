package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 7;
		for (int i = 5; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-1] + arr[i-3];
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(arr[n]);
		}
	}

}
