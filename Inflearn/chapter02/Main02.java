package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * 선생님이 N명의 학생을 일렬로 세웠습니다.
	 * 
	 * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
	 * 
	 * 선생님이 볼 수 있는 학생의 수를 구해라
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int max = Integer.parseInt(st.nextToken());
		int answer = 1;
		for (int i = 1; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp > max) {
				answer++;
				max = temp;
			}
		}
		System.out.println(answer);
	}

}
