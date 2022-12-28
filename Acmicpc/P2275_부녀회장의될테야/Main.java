import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[15][15];
		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = i;
		}
		//로직
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(arr[k][n]);
		}

	} 

}
