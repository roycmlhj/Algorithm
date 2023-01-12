package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String B = st.nextToken();
		int[][] map = new int[A.length()+1][B.length()+1];
		for (int i = 0; i < A.length(); i++) {
			map[i][0] = 0;
		}
		for (int i = 0; i < B.length(); i++) {
			map[0][i] = 0;
		}
		//로직
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					map[i][j] = map[i-1][j-1]+1;
				}else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		System.out.println(map[A.length()][B.length()]);
	}

}
