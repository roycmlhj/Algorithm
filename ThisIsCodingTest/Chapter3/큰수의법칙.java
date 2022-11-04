package chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int first = arr[n-1];
		int second = arr[n-2];

		int count = (m / (k + 1)) * k;
		count += m % (k + 1);
		
		int res = 0;
		res += count * first;
		res += (m-count) * second;
		
		System.out.print(res);
	}

}
