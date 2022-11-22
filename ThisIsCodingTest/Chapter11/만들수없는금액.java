package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 만들수없는금액 {
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		int answer = 1;
		for (int i = 0; i < n; i++) {
			if (answer < list.get(i)) {
				break;
			}
			answer += list.get(i);
		}
		System.out.println(answer);
	}

}
