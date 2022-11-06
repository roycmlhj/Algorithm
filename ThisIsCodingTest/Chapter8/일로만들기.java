package chapter8;

import java.util.Scanner;

public class 일로만들기 {
	static int[] arr = new int[30001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            arr[i] = arr[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                arr[i] = Math.min(arr[i], arr[i / 5] + 1);
        }
        
        System.out.println(arr[x]);
	}

}
