package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main09 {
	/*
	 *문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수
	 *만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이
	 */
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				continue;
			}else {
				temp += str.charAt(i);
			}
		}
		int answer = 0;
		for (int i = 0; i < temp.length(); i++) {
			int t = Integer.parseInt(Character.toString(temp.charAt(i)));
			int hun = 1;
			for (int j = i; j < temp.length()-1; j++) {
				hun = hun*10;
			}
			answer += t*hun;
		}
		System.out.println(answer);
	}
}
