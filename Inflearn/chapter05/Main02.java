package chapter05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * 입력된 문자열에서 소괄호 ( ) 사이에
	 * 
	 *  존재하는 모든 문자를 제거하고 남은 문자만 출력
	 * 
	 */
	public static String str;
	public static String answer = "";

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		// 로직
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.peek()==')') {
				while(stack.peek()!='(') {
					stack.pop();
				}
				stack.pop();
			}
		}
		// 출력
		for(char x:stack) {
			System.out.print(x);			
		}
	}

}
