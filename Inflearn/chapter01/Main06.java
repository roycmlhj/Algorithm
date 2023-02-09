package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
	/*
	 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if(i == str.indexOf(str.charAt(i))) {
				answer += str.charAt(i);
			}else {
				continue;
			}
		}
		System.out.println(answer);
	}
}
