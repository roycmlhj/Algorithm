import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> burger = new Stack<>();
        for(int i=0;i<ingredient.length;i++){
            burger.push(ingredient[i]);
            if(burger.size() >= 4){
                if(burger.get(burger.size()-1)==1 && burger.get(burger.size()-4)==1 && burger.get(burger.size()-2)==3 && burger.get(burger.size()-3)==2){
                    answer += 1;
                    burger.pop();
                    burger.pop();
                    burger.pop();
                    burger.pop();
                }
            }
        }
        return answer;
    }
}
