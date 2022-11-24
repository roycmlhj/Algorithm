package chapter12;

import java.util.Scanner;

public class 럭키스트레이트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int left = 0;
		int right = 0;
		for (int i = 0; i < str.length()/2; i++) {
			left += str.charAt(i) - '0';
		}
		for (int i = str.length()/2; i < str.length(); i++) {
			right += str.charAt(i) - '0';
		}
		if(left == right) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
	}

}
