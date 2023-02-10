package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main07 {
	/*
	 * 여러 개의 OX 문제로 만들어진 시험에서
	 * 
	 * 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int temp = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] == 0) {
				temp = 0;
			}else if(arr[i] == 1) {
				temp++;
				sum+=temp;
			}
		}
		System.out.print(sum);
	}
}
