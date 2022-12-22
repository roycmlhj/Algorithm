import java.util.Scanner;
public class Main {
    public static final int Max = 1000000;
    public static int n;
    public static int[] arr = new int[Max];
    public static int leader,member;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        leader = sc.nextInt();
        member = sc.nextInt();
        long answer = 0;
        for(int i=0;i<n;i++){
            answer += 1; //팀장은 무조건 한명 필요
            answer += calc(arr[i] - leader);
        }
        System.out.println(answer);
    }

    public static int calc(int remain){
        if(remain <= 0){
            return 0;
        }
        if(remain % member == 0){
            return remain/member;
        }else{
            return (remain/member) + 1;
        }
    }
}
