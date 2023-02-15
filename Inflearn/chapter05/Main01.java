package chapter05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main01 {
	/*
	 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
	 * 
	 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, 
	 * 
	 * (()()))은 올바른 괄호가 아니다. 
	 *  
	 */
	public static String str;
	public static String answer = "YES";
	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		// 로직
		Stack<Character> stack =new Stack<>();
		stack.push(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			}else if(str.charAt(i) == ')') {
				if(stack.isEmpty()) {
					answer = "NO";
					break;
				}
				stack.pop();
			}
		}
		// 출력
		if(!stack.isEmpty()) {
			answer = "NO";
		}
		System.out.println(answer);
	}

}
