import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){//캐시 사이즈가 0인 케이스
            return answer = cities.length * 5;
        }
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i=0;i<cities.length;i++){
            String under = cities[i].toLowerCase();
            int isInCnt = isIn(under,cities,arr);//1이면 있는거 0이면 없는거
            if(isInCnt == 1){//있어 > cache hit+1
                arr.remove(under);
                arr.add(under);//해당 문자열을 배열의 맨 뒤로 보내
                answer += 1;
            }else{//없어 > cache miss+5
                arr.add(under);//넣어
                if(arr.size() > cacheSize){// 캐시사이즈보다 크면 맨 앞 삭제
                    arr.remove(0);
                }
                answer += 5;
            }
        }
        
        return answer;
    }
    private int isIn(String s,String[] cities,ArrayList<String> arr){
        int temp = 0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).equals(s)){
                System.out.print("sdsdsd");
                temp = 1;
            }
        }
        return temp;
    }
}
