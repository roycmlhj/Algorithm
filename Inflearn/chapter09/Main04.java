package chapter09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main04 {
	/*
	 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다.
	 * 
	 * 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
	 * 
	 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
	 * 
	 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
	 * 
	 */
	static class Lecture implements Comparable<Lecture> {
		public int money;
		public int time;

		Lecture(int money, int time) {
			this.money = money;
			this.time = time;
		}

		@Override
		public int compareTo(Lecture ob) {
			return ob.time - this.time;
		}
	}

	public static int n = 0;
	public static int answer = 0;
	public static int max = Integer.MIN_VALUE;
	public static ArrayList<Lecture> arr = new ArrayList<Lecture>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Lecture(start, end));
			if (end > max) {
				max = end;
			}
		}
		// 로직
		Collections.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int j = 0;
		for (int i = max; i >= 1; i--) {
			for (; j < n; j++) {
				if (arr.get(j).time < i) {
					break;
				}
				pq.offer(arr.get(j).money);
			}
			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		// 출력
		System.out.println(answer);
	}

}
