import java.util.*;
class Solution {
    public int solution(int[] nums) { //int[] nums는 주어지는 배열
        int answer = 0;
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        
        //중복제거
        for(int i = 1; i<nums.length; i++){
            if(!list.contains(nums[i]))
                list.add(nums[i]);
        }
        
        if(list.size() < nums.length/2){
            answer = list.size();
        }
        else{
            answer = nums.length/2;
        }
        
        return answer; //answer는 가져갈수있는 폰켓몬 수
    }
    
}
