import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for(int i=0;i<operations.length;i++){
            String[] str = operations[i].split(" ");
            if(str[0].equals("I")){
                maxQueue.add(Integer.parseInt(str[1]));
                minQueue.add(Integer.parseInt(str[1]));
            }
            if (str[0].equals("D")) {
                if (!maxQueue.isEmpty()) {
                    if (str[1].equals("1")) {
                        int max = maxQueue.peek();
                        maxQueue.remove(max);
                        minQueue.remove(max);

                    } else {
                        int min = minQueue.peek();
                        maxQueue.remove(min);
                        minQueue.remove(min);
                    }
                }
            }
        }
        if (!maxQueue.isEmpty()) {
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();

        }
        return answer;
    }
}
