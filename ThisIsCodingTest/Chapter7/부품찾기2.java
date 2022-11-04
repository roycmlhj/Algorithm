package chapter7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 부품찾기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int m = sc.nextInt();
		int[] target = new int[m];
		for (int i = 0; i < m; i++) {
			target[i] = sc.nextInt();
		}
		
		for (int i = 0; i < m; i++) {
			int res = binarySearch(arr,target[i],0,N-1);
			if(res != -1) {
				System.out.println("yes ");
			}else {
				System.out.println("no ");
			}
		}
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {
				end = mid - 1;
			}else{
				start = mid+1;
			}
			
		}
		return -1;
	}

}
