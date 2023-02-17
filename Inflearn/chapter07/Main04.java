package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * 1) 피보나치 수열 출력(메모)
	 * 
	 * 2) 입력은 피보나치 수열의 총 항의 수
	 * 
	 * ex) 7 > 1 1 2 3 5 8 12 출력
	 * */
	public static int N = 0;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		arr[0] = 1;
		arr[1] = 1;
		// 로직
		for (int i = 2; i < N; i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		// 출력
		for(int x:arr) {
			System.out.print(x+" ");
		}
	}

}
