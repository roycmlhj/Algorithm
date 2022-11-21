package chapter11;

import java.util.Scanner;

public class 곱하기혹은더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int answer = str.charAt(0) - '0';
		for (int i = 1; i < str.length(); i++) {
			int temp = str.charAt(i) - '0';
			if(temp <= 1 || answer <=1) {
				answer += temp;
			}else {
				answer *= temp;
			}
		}
		System.out.println(answer);
	}

}
