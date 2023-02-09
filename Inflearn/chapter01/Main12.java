package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
	/*
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String code = st.nextToken();
		String answer = "";
		for (int i = 0; i < n; i++) {	
			String part = code.substring(0,7).replace('#', '1').replace('*', '0');
			int num = Integer.parseInt(part,2);
			answer += (char)num;
			code = code.substring(7);
		}
		System.out.println(answer);
	}
}
