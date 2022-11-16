package chapter10;

import java.util.Scanner;

public class 서로소집합을활용한사이클판별 {
	
	//노드 수 : v, 간선 수 : e
	static int v,e;
	static int[] parents = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		//부모테이블에서 부모를 자기 자신으로
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		
		//사이클 여부
		boolean cycle = false;
		
		//union
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(find(a) == find(b)) {//사이클인 경우
				cycle = true;
				break;
			}else {
				union(a,b);
			}
		}
		
		if (cycle) {
            System.out.println("사이클이 발생했습니다.");
        }
        else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }

	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		//각각의 부모를 찾은 후 크기를 비교하여 부모 갱신
		if(a < b) {
			parents[b] = a;
		}else {
			parents[a] = b;
		}
	}

	private static int find(int a) {
		//루트 노드 찾을때까지 재귀반복
		
		//자신이 부모이면 a 리턴
		if(a == parents[a]) {
			return a;
		}
		//자신이 부모가 아니면 내 부모를 통해서 find연산
		return parents[a] = find(parents[a]);
	}

}
