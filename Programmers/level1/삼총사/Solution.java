class Solution {
    public static int answer = 0;
    public int solution(int[] number) {
        combi(0,0,number,new boolean[number.length],3);
        return answer;
    }
    private static void combi(int idx,int depth,int[] number,boolean[] v,int num){
        if(depth == num){
            int temp = 0;
            for(int j = 0;j<number.length;j++){
                if(v[j]){
                    temp += number[j];
                }
            }
            if(temp == 0){
                answer += 1;
            }
            return;
        }
        for(int i=idx;i<number.length;i++){
            if(!v[i]){
                v[i] = true;
                combi(i+1,depth+1,number,v,num);
                v[i] = false;
            }
            
        }
    }
}
