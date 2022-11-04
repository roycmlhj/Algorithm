package chapter4;

import java.util.Scanner;

public class 왕실의나이트 {
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		int row = str.charAt(1) - '0';
		int col = str.charAt(0) - 'a' + 1;
		
		int answer = 0;
		
		for (int i = 0; i < 8; i++) {
			int nr = row + dx[i];
			int nx = col + dy[i];
			if(nr >= 1 && nx >= 1 && nr <= 8 && nx <= 8) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}
