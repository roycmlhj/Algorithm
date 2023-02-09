package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main05 {
	/*
	 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
	 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		char[] arr = str.toCharArray();
		int lt = 0;
		int rt = arr.length-1;
		while(lt < rt) { //lt가 rt보다 작을때까지만 돌아라
			if(!Character.isAlphabetic(arr[lt])) {
				lt++;
			}else if(!Character.isAlphabetic(arr[rt])) {
				rt--;
			}else {
				char temp = arr[lt];
				arr[lt] = arr[rt];
				arr[rt] = temp;
				lt++;
				rt--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
