package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01 {
	/*
	 * 한 개의 문자열을 입력받고,
	 * 특정 문자를 입력받아 해당 특정문자가
	 * 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성*/ 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String temp = st.nextToken();
		temp = temp.toLowerCase();
		Character find = temp.charAt(0);
		int answer = 0;
		input = input.toLowerCase();
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == find) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
