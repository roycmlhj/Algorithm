package chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하라
	 * 
	 * 아나그램 판별시 대소문자가 구분됩니다. 
	 * 
	 * 부분문자열은 연속된 문자열이어야 함
	 */
	
	public static String S, T;
	//public static int[] arr;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = st.nextToken();
		st = new StringTokenizer(br.readLine());
		T = st.nextToken();
		// 로직
		HashMap<Character, Integer> Tmap = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			Tmap.put(T.charAt(i), Tmap.getOrDefault(T.charAt(i), 0)+1);
		}
		HashMap<Character, Integer> Smap = new HashMap<>();
		for (int i = 0; i < T.length()-1; i++) {
			Smap.put(S.charAt(i), Smap.getOrDefault(S.charAt(i), 0)+1);
		}
		int lt = 0;
		for (int rt = T.length()-1; rt < S.length(); rt++) {
			Smap.put(S.charAt(rt), Smap.getOrDefault(S.charAt(rt), 0)+1);
			if(Smap.equals(Tmap)) {
				answer++;
			}
			Smap.put(S.charAt(lt), Smap.getOrDefault(S.charAt(lt), 0)-1);
			if(Smap.get(S.charAt(lt))==0) {
				Smap.remove(S.charAt(lt));
			}
			lt++;
		}
		// 출력
		System.out.println(answer);

	}

}
