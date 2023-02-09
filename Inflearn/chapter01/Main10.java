package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
	/*
	 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		String t = st.nextToken();
		int p = 1001;
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (Character.toString(str.charAt(i)).equals(t)) {
				p = 0;
				arr[i] = p;
			} else {
				p++;
				arr[i] = p;
			}
		}
		p = 1001;
		for (int i = str.length()-1; i >= 0; i--) {
			if (Character.toString(str.charAt(i)).equals(t)) {
				p = 0;
				arr[i] = p;
			}else {
				p++;
				arr[i] = Math.min(p, arr[i]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
