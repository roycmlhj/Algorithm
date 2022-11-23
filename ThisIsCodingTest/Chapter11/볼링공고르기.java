package chapter11;

import java.util.Arrays;
import java.util.Scanner;

public class 볼링공고르기 {
	static int n, m;
	static int[] arr = new int[11];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			arr[temp] += 1;
		}
		int answer = 0;
		for (int i = 1; i <= m; i++) {
			n -= arr[i];
			answer += arr[i] * n;
		}
		
		System.out.println(answer);
	}
}
