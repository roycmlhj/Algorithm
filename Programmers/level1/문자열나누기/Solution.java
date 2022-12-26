class Solution {
    public int solution(String s) {
        int answer = 0;
        int eq = 1;
        int neq = 0;
        char start = s.charAt(0);
        for(int i=1;i<s.length()-1;i++){
            if(start == s.charAt(i)){
                eq+=1;
            }else{
                neq+=1;
            }
            
            if(eq == neq){
                answer += 1;
                eq=0;
                neq=0;
                start = s.charAt(i+1);
            }
        }
        return answer+1;
    }
}
