import java.util.*;
class Solution {
    static char[] arr;
    static boolean[] v;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        arr = new char[numbers.length()];
        v = new boolean[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            arr[i] = numbers.charAt(i);
        }
        combi("",0);
        answer = set.size();
        return answer;
    }
    private static void combi(String str,int num){
        int temp = 0;
        if(str!=""){
            temp = Integer.parseInt(str);
            if(isPrime(temp)){
                set.add(temp);
            }
        }
        if(num == arr.length){
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(v[i]){
                continue;
            }
            v[i] = true;
            combi(str+arr[i],num+1);
            v[i] = false;
        }
    }
    private static boolean isPrime(int a){
        if(a==0||a==1){
            return false;
        }
        for(int i=2; i*i<=a;i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}
