import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        //int[] answer = {};
        int[] first = {1, 2, 3, 4, 5};
        int firstAnswer = 0;
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int secondAnswer = 0;
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int thirdAnswer = 0;
        
        for(int i=0; i<answers.length;i++){
            if(first[i%first.length] == answers[i]) firstAnswer++;
            if(second[i%second.length] == answers[i]) secondAnswer++;
            if(third[i%third.length] == answers[i]) thirdAnswer++;
        }
        
        int max = Math.max(Math.max(firstAnswer, secondAnswer),thirdAnswer);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==firstAnswer) list.add(1);
        if(max==secondAnswer) list.add(2);
        if(max==thirdAnswer) list.add(3);
        int[] answer = new int[list.size()];
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
