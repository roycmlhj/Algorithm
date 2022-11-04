package chapter7;

import java.util.HashSet;
import java.util.Scanner;

public class 부품찾기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hash.add(sc.nextInt());
		}
		
		int m = sc.nextInt();
		int[] target = new int[m];
		for (int i = 0; i < m; i++) {
			target[i] = sc.nextInt();
		}
		
		for (int i = 0; i < m; i++) {
			if(hash.contains(target[i])) {
				System.out.print("yes ");
			}else {
				System.out.println("no ");
			}
		}
	}

}
