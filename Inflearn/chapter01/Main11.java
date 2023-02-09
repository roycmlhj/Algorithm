package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {
	/*
	 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
	 * 
	 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
	 * 
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		str = str+" ";
		char[] arr = str.toCharArray();
		String answer = "";
		int cnt = 1;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				cnt++;
			}else {
				answer += arr[i];
				if(cnt > 1) {
					answer += Integer.toString(cnt);
					cnt = 1;
				}
			}
		}
		System.out.print(answer);
	}
}
