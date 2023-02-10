package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main08 {
	/*
	 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력
	 * 
	 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
	 * 
	 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = 1;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < answer.length; j++) {
				if(i == j) {
					continue;
				}
				if(arr[i] < arr[j]) {
					answer[i] += 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
