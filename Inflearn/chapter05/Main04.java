package chapter05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
	 * 
	 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면
	 * 
	 * 352+*9- 로 표현되며 그 결과는 12입니다.
	 */
	public static String str;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		// 로직
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {//숫자면 스택에 넣기
				stack.push(Character.getNumericValue(str.charAt(i)));
			}else {
				int b = stack.pop();
				int a = stack.pop();
				if(str.charAt(i)=='+') {
					stack.push(a+b);
				}else if(str.charAt(i)=='-') {
					stack.push(a-b);
				}else if(str.charAt(i)=='*') {
					stack.push(a*b);
				}else if(str.charAt(i)=='/') {
					stack.push(a/b);
				}
			}
		}
		// 출력
		System.out.println(stack.peek());
	}

}
