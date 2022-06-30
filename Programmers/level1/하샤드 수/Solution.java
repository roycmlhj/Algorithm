class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int copy = x;
        int sum_x = 0;
        
        while(copy >= 1){
            sum_x += copy%10;
            copy /= 10;
        }
        if(x%sum_x == 0){
            answer = true;
        }else{
            answer = false;
        }
        
        return answer;
    }
}
