
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int answer0 = 0;
	public static int answer1 = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(arr[n][0] + " " + arr[n][1]);
		}

	}

}
