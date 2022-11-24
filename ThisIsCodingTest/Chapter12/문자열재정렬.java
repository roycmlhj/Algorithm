package chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열재정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String answer = "";
		ArrayList<Character> arr = new ArrayList<>();
		int numbers = 0;
		for (int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				arr.add(str.charAt(i));
			}else {
				numbers += str.charAt(i) - '0';
			}
		}
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			answer += arr.get(i);
		}
		System.out.print(answer);
		System.out.print(numbers);
	}

}
