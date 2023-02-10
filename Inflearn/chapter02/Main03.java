package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * A, B 두 사람이 가위바위보 게임을 합니다. 
	 * 
	 * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 
	 * 
	 * 비길 경우에는 D를 출력
	 * 
	 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[3][N];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			if(map[0][i] == map[1][i]) {
				arr[i] = "D";
			}else if(map[0][i] == 1 && map[1][i] == 2) {
				arr[i] = "B";
			}else if(map[0][i] == 1 && map[1][i] == 3) {
				arr[i] = "A";
			}else if(map[0][i] == 2 && map[1][i] == 3) {
				arr[i] = "B";
			}else if(map[0][i] == 2 && map[1][i] == 1) {
				arr[i] = "A";
			}else if(map[0][i] == 3 && map[1][i] == 2) {
				arr[i] = "A";
			}else if(map[0][i] == 3 && map[1][i] == 1) {
				arr[i] = "B";
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
