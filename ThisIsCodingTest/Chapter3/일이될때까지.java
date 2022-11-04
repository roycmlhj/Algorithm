package chapter3;

import java.util.Scanner;

public class 일이될때까지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int res = 0;
		
		while(true) {
			if(n % m == 0) {
				n = n / m;
				res++;
				if(n == 0) {
					break;
				}
			}else {
				n = n-1;
				res++;
				if(n == 0) {
					break;
				}
			}
		}
		
		System.out.println(res-1);
		
	}

}
