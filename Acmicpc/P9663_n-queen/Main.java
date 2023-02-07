package bruteforce; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9663 {
	public static int n,answer;
	public static int[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n];
		nqueen(0);
		System.out.print(answer);
	}
	private static void nqueen(int i) {
		if(i == n) {
			answer+=1;
			return;
		}
		for (int j = 0; j < n; j++) {
			map[i] = j;
			if(isIn(i)) {
				nqueen(i+1);
			}
		}
	}
	private static boolean isIn(int i) {
		for (int j = 0; j < i; j++) {
			if(map[i] == map[j]) {//현재 위치에 퀸 있음
				return false;
			}
			if(Math.abs(j-i)==Math.abs(map[j]-map[i])) {
				return false;
			}
		}
		return true;
	}

}
