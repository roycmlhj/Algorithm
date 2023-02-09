package chapter01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
	/*
	 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열. 
	 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES"
	 * 회문 문자열이 아니면 “NO"를 출력
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		str = str.toLowerCase();
		int lt = 0;
		int rt = str.length()-1;
		boolean state = true;
		while(lt <= rt) {
			if(lt == rt) {
				break;
			}
			if(str.charAt(lt)!=str.charAt(rt)) { //양 끝이 다르다
				state = false;
				break;
			}
			if(str.charAt(lt)==str.charAt(rt)) {
				state = true;
				lt++;
				rt--;
			}
		}
		if(state == false) {
			System.out.println("NO");
		}else if(state == true) {
			System.out.println("YES");
		}
		//System.out.println(answer);
	}
}
