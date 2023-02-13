package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main02 {
	/*
	 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력
	 */
	public static int N,M;
	public static int[] arr1,arr2;
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		//입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr1 = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<>();
		//로직
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int p1 = 0;
		int p2 = 0;
		while(p1<N && p2<M) {//p1이 N보다 작고 p2가 M보다 작을때까지만 돌아라
			if(arr1[p1] == arr2[p2]) {
				list.add(arr1[p1]);
				p1++;
				p2++;
			}else if(arr1[p1] < arr2[p2]) {
				p1++;
			}else if(arr1[p1] > arr2[p2]) {
				p2++;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

}
