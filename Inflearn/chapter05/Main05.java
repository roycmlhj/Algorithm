package chapter05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main05 {
	/*
	 * 쇠막대기 자르기
	 */
	public static String str;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		// 로직
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
			} else {
				stack.pop();
				if (str.charAt(i - 1) == '(') {// 레이저
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}
		// 출력
		System.out.println(answer);
	}

}
