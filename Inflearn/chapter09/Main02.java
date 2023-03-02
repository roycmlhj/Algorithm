package chapter09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
	 * 
	 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 
	 * 
	 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
	 * 
	 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
	 * 
	 */
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) { // 오름차순
			if(this.end == o.end) {
				return this.start - o.start;
			}else {
				return this.end - o.end;
			}
		}
	}
	public static int n = 0;
	public static ArrayList<Meeting> arr = new ArrayList<Meeting>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Meeting(start,end));
		}
		// 로직
		int cnt = 0;
		Collections.sort(arr);
		int endTime = 0;
		for(Meeting m : arr) {
			if(m.start >= endTime) {
				cnt++;
				endTime = m.end;
			}
		}
		// 출력
		System.out.println(cnt);
	}

}
