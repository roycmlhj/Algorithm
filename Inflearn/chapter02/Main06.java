package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main06 {
	/*
	 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후
	 * 
	 * 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
	 * 
	 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 
	 * 
	 * 단 910를 뒤집으면 19로 숫자화 해야 한다.
	 */
	public static ArrayList<Integer> list= new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			int temp = arr[i];
			int res = 0;
			while(temp > 0) {
				int t = temp%10;
				res = res*10+t;
				temp = temp/10;
			}
			if(isPrime(res)) {
				list.add(res);
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	private static boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		for (int i = 2; i < num; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}
