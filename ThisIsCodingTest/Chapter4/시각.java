package chapter4;

import java.util.Scanner;

public class 시각 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 60; j++) {
				for (int j2 = 0; j2 < 60; j2++) {
					if (check(i, j, j2)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	private static boolean check(int h, int m, int s) {
		if (h % 10 == 3 || m % 10 == 3 || s % 10 == 3 || m / 10 == 3 || s / 10 == 3) {
			return true;
		}
		return false;
	}

}
