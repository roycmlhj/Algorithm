package chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * N일 동안의 매출기록에서 연속된 K일 동안의 매출액의 종류를
	 * 
	 * 각 구간별로 구하라고 했습니다.
	 * 
	 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
	 * 
	 * 20 12 20 10 23 17 10
	 * 
	 * 각 연속 4일간의 구간의 매출종류는
	 * 
	 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
	 * 
	 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
	 * 
	 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
	 * 
	 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
	 * 
	 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
	 * 
	 * 매출액의 종류를 출력
	 * 
	 */
	public static int N,M;
	public static int[] arr;
	public static int answer = 0;

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
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < M-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int lt = 0;
		for (int rt = M-1; rt < N; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			System.out.print(map.size()+" ");
			map.put(arr[lt], map.getOrDefault(arr[lt], 0)-1);
			if(map.get(arr[lt])==0) {
				map.remove(arr[lt]);
			}
			lt++;
		}
		

		// 출력
		//System.out.println(answer);

	}

}
