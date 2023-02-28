package chapter08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14 {
	/*
	 * 피자 배달 거리 N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
	 * 
	 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
	 * 
	 * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
	 * 
	 * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
	 * 
	 * 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
	 * 
	 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
	 * 
	 * 예를 들어, 도시의 지도가 아래와 같다면
	 * 
	 * 0 1 0 0
	 * 
	 * 0 0 2 1
	 * 
	 * 0 0 1 0
	 * 
	 * 1 2 0 2
	 * 
	 * 
	 * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
	 * 
	 * 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
	 * 
	 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
	 * 
	 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
	 * 
	 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
	 * 
	 */
	public static int n, m;
	public static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	public static int[] dy = { 0, 1, 0, -1 };
	// public static int[][] map;
	public static ArrayList<int[]> house = new ArrayList<int[]>();
	public static ArrayList<int[]> pizza = new ArrayList<int[]>();
	public static int[] check;
	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// map = new int[n][n];
		check = new int[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {// 집
					int[] t1 = { i, j };
					house.add(t1);
				} else if (temp == 2) {// 피자
					int[] t2 = { i, j };
					pizza.add(t2);
				}
			}
		}
		// 로직
		dfs(0, 0, pizza.size()); // level, start
		// 출력
		System.out.println(answer);
	}

	private static void dfs(int l, int s, int len) {
		if (l == m) {
			int sum = 0;
			for (int[] x : house) {
				int x1 = x[0];
				int y1 = x[1];
				int dist = Integer.MAX_VALUE;
				for (int i : check) {
					dist = Math.min(dist, Math.abs(x1 - pizza.get(i)[0]) + Math.abs(y1 - pizza.get(i)[1]));
				}
				sum += dist;
			}
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				check[l] = i;
				dfs(l + 1, i + 1, len);
			}
		}

	}

}
