package chapter4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 상하좌우 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[] way = {'U','R','D','L'};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine(); //버퍼 비우기
		String[] arr = sc.nextLine().split(" ");
		int nr = 1;
		int nx = 1;
		for (int i = 0; i < arr.length; i++) {
			char tempWay = arr[i].charAt(0);
			int r = 0;
			int x = 0;
			for (int j = 0; j < 4; j++) {
				if(way[j] == tempWay) {
					r = nr + dx[j];
					x = nx + dy[j];
				}
			}
			if(r < 1 || x < 1 || r > N || x > N) {
				continue;
			}
			nr = r;
			nx = x;
			//System.out.println("중간점검 nr:"+nr + " nx:" + nx);
		}
		System.out.println(nr + " " + nx);
	}

}
