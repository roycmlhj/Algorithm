package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * N개의 단어가 주어지면 각 단어를 뒤집어 출력*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String newStr = "";
			for (Character x : str.toCharArray()) {
				newStr = x + newStr;
			}
			System.out.println(newStr);
		}
	}

}
