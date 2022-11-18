package chapter10;

import java.util.Scanner;

public class 팀결성 {
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		//부모 테이블 초기화
		int[] parents = new int[n+1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		for (int i = 0; i <= n; i++) {
			int ope = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(ope == 0) {//팀 합치기,union
				union(a,b,parents);
			}else if(ope == 1) {//같은 팀 여부 확인,find
				if(find(a,parents) == find(b,parents)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}

	}
	private static int find(int a, int[] parents) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a],parents);
	}
	private static void union(int a, int b, int[] parents) {
		a = find(a,parents);
		b = find(b,parents);
		if(a < b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
	}

}
