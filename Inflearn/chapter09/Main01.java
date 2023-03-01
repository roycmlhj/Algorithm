package chapter09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main01 {
	/**/
	static class body implements Comparable<body> {
		int h;
		int w;

		public body(int h, int w) {
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(body o) {
			return o.h - this.h;
		}

	}

	// 섹션 6 좌표정렬 복습
	public static int n = 0;
	public static ArrayList<body> arr = new ArrayList<body>();

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.add(new body(h, w));
		}
		// 로직
		int cnt = 0;
		Collections.sort(arr);
		int max = Integer.MIN_VALUE;
		for (body ob : arr) {
			if (ob.w > max) {
				max = ob.w;
				cnt++;
			}
		}
		// 출력
		System.out.println(cnt);
	}

}
