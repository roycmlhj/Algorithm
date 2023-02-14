package chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main01 {
	/*
	 * 학급 회장을 뽑는데 기호 A, B, C, D, E 후보가 등록
	 * 
	 * 투표용지에는 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며
	 * 
	 * 선생님은 그 기호를 발표하고 있습니다.
	 * 
	 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력
	 * 
	 */
	public static int N;
	public static String str;
	public static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		// 로직
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			map.put(temp,map.getOrDefault(temp, 0)+1);
		}
		for(char x : map.keySet()) {
			if(answer < map.get(x)) {
				answer = Math.max(answer, map.get(x));
				str = x + "";
			}
		}
		// 출력
		System.out.print(str);

	}

}
