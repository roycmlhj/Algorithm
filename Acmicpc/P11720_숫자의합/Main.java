import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String num = sc.next();
        char[] carr = num.toCharArray();
        int sum = 0;
        for (int i = 0; i < carr.length; i++) {
            sum += carr[i] - '0';
        }
        System.out.println(sum);
    }
}