import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dataNum = Integer.parseInt(st.nextToken());
        int windowNum = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[dataNum + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= dataNum; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < windowNum; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[end] - sumArr[start - 1]);
        }
    }

}
