package chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
	 * 
	 * AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만
	 * 
	 * 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재
	 * 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
	 * 
	 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별
	 * 
	 */
	public static int N;
	public static String str1, str2;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		str2 = st.nextToken();
		// 로직
		HashMap<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char temp1 = str1.charAt(i);
			map1.put(temp1, map1.getOrDefault(temp1, 0) + 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			char temp2 = str2.charAt(i);
			if(!map1.containsKey(temp2) || map1.get(temp2)==0) {
				answer = 1;
				break;
			}
			map1.put(temp2, map1.getOrDefault(temp2, 0) - 1);
		}
		
		// 출력
		if(answer == 1) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}

	}

}
