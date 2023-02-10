package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main12 {
	/*
	 * 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면,
	 * 
	 * A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
	 * 
	 * M번의 수학성적이 주어지면 멘토와 멘티가
	 * 
	 * 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력
	 */
	public static int M, N;
	public static int[][] map;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {// i번째 학생
			for (int j = 1; j <= N; j++) {// j번째 학생
				int cnt = 0;
				for (int k = 0; k < M; k++) { // test
					int pi = 0;
					int pj = 0;
					for (int s = 0; s < N; s++) {// 등수
						if (map[k][s] == i) {
							pi = s;
						}
						if (map[k][s] == j) {
							pj = s;
						}
					}
					if(pi < pj) {
						cnt++;
					}
				}
				if(cnt==M) {
					answer++;
				}
			}
		}

		System.out.print(answer);
	}
}
