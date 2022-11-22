package chapter11;

import java.util.Scanner;

public class 문자열뒤집기 {
	static int count0;
	static int count1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		if (str.charAt(0) == '0') {
			count0 += 1;
		} else {
			count1 += 1;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				if (str.charAt(i + 1) == '1') {
					count0 += 1;
				} else {
					count1 += 1;
				}
			}
		}
		System.out.println(Math.min(count0, count1));
	}

}
