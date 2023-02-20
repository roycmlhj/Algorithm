package chapter07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main08 {
	/*
	 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
	 * 
	 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면
	 * 
	 * 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
	 * 
	 * 송아지는 움직이지 않고 제자리에 있다.
	 * 
	 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
	 * 
	 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
	 * 
	 * 
	 * 
	 */
	public static int S, E;
	public static int answer = 0;
	public static int[] d = { 1, -1, 5 };
	public static int[] v;
	public static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		v = new int[10001];
		v[S] = 1; // 현수의 위치
		queue.offer(S);
		int level = 0;
		// 로직
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int x = queue.poll();
				if(x==E) {
					answer = level;
					break;
				}
				for (int j = 0; j < 3; j++) {
					int nx = x + d[j];
					if (nx >= 1 && nx <= 10000 && v[nx] == 0) { // 범위를 벗어나지 않고 방문안했으면
						v[nx] = 1;
						queue.offer(nx);
					}
				}
			}//i번째 레밸 순회 끝
			level++;
		}
		// 출력
		System.out.print(answer);
	}
}
