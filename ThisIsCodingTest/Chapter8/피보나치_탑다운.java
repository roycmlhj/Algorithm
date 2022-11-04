package chapter8;

public class 피보나치_탑다운 {
	static long[] arr = new long[100];
	public static void main(String[] args) {
		System.out.println(fibo(50));
	}
	private static long fibo(int i) {
		// TODO Auto-generated method stub
		if(i == 1 || i == 2) {
			return 1;
		}
		if(arr[i] != 0) {
			return arr[i];
		}
		arr[i] = fibo(i-1) + fibo(i-2);
		return arr[i];
	}

}
