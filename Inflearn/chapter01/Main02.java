package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * 대문자와 소문자가 같이 존재하는 문자열을 입력
	 * 대문자는 소문자로 소문자는 대문자로 변환*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		String answer = "";
		for(Character x : input.toCharArray()) {
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			}else if(Character.isUpperCase(x)) {
				answer += Character.toLowerCase(x);
			}
		}
		System.out.println(answer);
	}

}
