package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 모험가길드 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		
		int group = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			group += 1;
			if(group >= list.get(i)) {
				answer += 1;
				group = 0;
			}
		}
		System.out.println(answer);
	}

}
