class Solution {
    public static int gcd(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        
        while(max % min != 0){
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            int gcd = gcd(answer,arr[i]);
            answer = answer * arr[i] / gcd;
        }
        return answer;
    }
}
