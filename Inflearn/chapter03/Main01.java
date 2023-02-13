package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main01 {
	/*
	 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
	 */
	public static int N,M;
	public static int[] arr1,arr2,arr3;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr1 = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		arr3 = new int[N+M];
		for (int i = 0; i < N; i++) {
			arr3[i] = arr1[i];
		}
		for (int i = 0; i < M; i++) {
			arr3[i+N] = arr2[i];
		}
		Arrays.sort(arr3);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " " );
		}
	}

}
