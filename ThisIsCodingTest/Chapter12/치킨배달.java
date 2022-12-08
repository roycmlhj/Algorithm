package chapter12;

import java.util.ArrayList;
import java.util.Scanner;

public class 치킨배달 {
	static int N;
	static int C;
	static int min = Integer.MAX_VALUE;
	static int[][] map; 
	static ArrayList<int[]> home;
	static ArrayList<int[]> chicken;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		C = sc.nextInt();
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {// 집
					home.add(new int[] {i, j});
				} else if (map[i][j] == 2) { // 치킨집
					chicken.add(new int[] {i, j});
				}
			}
		}
		// 로직
		v = new boolean[chicken.size()];
		combi(0, 0);
		System.out.println(min);
	}

	public static void combi(int start, int cnt) {

		if (cnt == C) { // C만큼 다 골랐어
            int dist = 0;

            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (v[j])
                    	tmp = Math.min(tmp, Math.abs(home.get(i)[0] - chicken.get(j)[0]) + Math.abs(home.get(i)[1] - chicken.get(j)[1]));
                }
                dist += tmp;
            }
            min = Math.min(min, dist);
            return;
		}

		for (int i = start; i < v.length; i++) {
			v[i] = true;
			combi(i + 1, cnt + 1);
			v[i] = false;
		}
	}

}
