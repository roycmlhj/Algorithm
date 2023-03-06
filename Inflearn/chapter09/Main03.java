package chapter09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main03 {
	/*
	 * 현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
	 * 
	 * 피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
	 * 
	 * 각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
	 * 
	 * 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이
	 * 현수를 도와주세요.
	 * 
	 * 만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고
	 * 가정합니다.
	 * 
	 * 
	 * 입력
	 */
	static class Time implements Comparable<Time> {
		public int time;
		public char state;

		Time(int time, char state) {
			this.time = time;
			this.state = state;
		}

		@Override
		public int compareTo(Time ob) {
			if (this.time == ob.time)
				return this.state - ob.state;
			else
				return this.time - ob.time;
		}
	}

	public static int n = 0;
	public static ArrayList<Time> arr = new ArrayList<Time>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Time(start, 's'));
			arr.add(new Time(end, 'e'));
		}
		// 로직
		int answer = Integer.MIN_VALUE;
		Collections.sort(arr);
		int cnt = 0;
		for (Time ob : arr) {
			if (ob.state == 's') {
				cnt++;
			} else {
				cnt--;
			}
			answer = Math.max(answer, cnt);
		}
		// 출력
		System.out.println(answer);
	}

}
