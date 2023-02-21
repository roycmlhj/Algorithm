package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01 {
	/*
	 * N개의 원소로 구성된 자연수 집합이 주어지면
	 * 
	 * 이 집합을 두 개의 부분집합으로 나누었을 때
	 * 
	 * 두 부분집합의 원소의 합이 서로 같은 경우가
	 * 
	 * 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력
	 * 
	 * 둘로 나뉘는 두 부분집합은 서로소 집합이며,
	 * 
	 * 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
	 * 
	 * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면
	 * 
	 * {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우 존재
	 */
	public static int N;
	public static int total = 0;
	public static int[] arr;
	public static String answer = "NO";
	public static boolean flag = false;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		// 로직
		dfs(0,0);//level,sum
		// 출력
		System.out.print(answer);

	}

	private static void dfs(int level, int sum) {
		if(level == N) {
			if(total-sum == sum){
				answer = "YES";
				flag = true;
			}
		}else {
			dfs(level+1,sum+arr[level]); //해당 원소 사용
			dfs(level+1,sum);//해당 원소 사용x
		}
		
	}

}
