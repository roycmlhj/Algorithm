package chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main05 {
	/*
	 * 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있다.
	 * 
	 * 같은 숫자의 카드가 여러장 있을 수 있습니다.
	 * 
	 * 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록
	 * 
	 * 3장을 뽑을 수 있는 모든 경우를 기록합니다.
	 * 
	 * 기록한 값 중 K번째로 큰 수를 출력
	 * 
	 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고
	 * 
	 * K값이 3이라면 K번째 큰 값은 22
	 */
	public static int N, M;
	public static int[] arr;
	public static int answer = -1;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 로직
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
		for (int first = 0; first < N; first++) {
			for (int second = first + 1; second < N; second++) {
				for (int third = second + 1; third < N; third++) {
					Tset.add(arr[first]+arr[second]+arr[third]);
				}
			}
		}
		// 출력
		int cnt = 0;
		for(int x:Tset) {
			cnt++;
			if(cnt==M) {
				answer = x;
			}
		}
		System.out.println(answer);

	}

}
