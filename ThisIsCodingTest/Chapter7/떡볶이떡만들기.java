package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이떡만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
//		for (int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//			
//		}

		int start = 0;
		int end = arr[N - 1];
		int answer = 0;
		while (start <= end) {
			long total = 0;
			int mid = (start + end) / 2; // start와 end의 mid를 칼이라고 생각해서 자른다
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					total += arr[i] - mid;
				}
			}
			if (total < M) {// 떡이 부족
				end = mid - 1;
			} else {// 떡이 충분
				answer = mid;
				start = mid + 1;
			}
		}
		System.out.println(answer);
	}

}
