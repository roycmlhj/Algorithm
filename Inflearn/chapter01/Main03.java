package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * 한 개의 문장이 주어지면 그 문장 속 가장 긴 단어 출력*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		String answer = "";
		int max = Integer.MIN_VALUE;
		String[] s = temp.split(" ");
		for (int i = s.length-1; i >=0; i--) {
			if(max < s[i].length()) {
				max = Math.max(max, s[i].length());
				answer = s[i];
				
			}
		}
		System.out.println(answer);
	}

}
