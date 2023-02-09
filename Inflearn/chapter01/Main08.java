package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08 {
	/*
	 *앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
	 *문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				newStr = newStr + Character.toLowerCase(str.charAt(i));
			}
		}
		newStr = newStr.toLowerCase();
		//System.out.println(newStr);
		int lt = 0;
		int rt = newStr.length()-1;
		boolean state = true;
		while(lt <= rt) {
			if(lt == rt) {
				break;
			}
			if(newStr.charAt(lt) == newStr.charAt(rt)) {
				lt++;
				rt--;
			}else if(newStr.charAt(lt) != newStr.charAt(rt)) {
				state = false;
				break;
			}
		}
		if(state == false) {
			System.out.println("NO");
		}else if(state == true) {
			System.out.println("YES");
		}
	}
}
