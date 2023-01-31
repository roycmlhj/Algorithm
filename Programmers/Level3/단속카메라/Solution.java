import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        int endpoint = routes[0][1];
        answer++;
        for(int i = 1; i < routes.length; i++){
            if(endpoint < routes[i][0]){
                answer++;
                endpoint = routes[i][1];
            }
        }
        
        return answer;
    }
}
