class Solution { 
    public int solution(String s) {
        int answer = s.length();
        if(s.length() == 1){return 1;}
        for(int i = 1;i<=s.length()/2;i++){
            String str = "";
            String temp = "";
            int cnt = 1;
            for(int j =0;j<s.length()/i;j++){
                if(temp.equals(s.substring(j*i,(j*i)+i))){
                    cnt++;
                    continue;
                }
                if(cnt>1){
                    str += cnt+temp; 
                    cnt=1;
                }else{
                    str+=temp;
                }
                temp = s.substring(j*i,(j*i)+i);
            }
            if(cnt>1){
                str+=cnt+temp;
                cnt=1;
            }else{
                str+=temp;
            }
            if(s.length()%i !=0){
                str+=s.substring(s.length()-s.length()%i,s.length());
            }
            if(answer > str.length()){
                answer = str.length();
            }else{
                answer = answer;
            }
        }
        return answer;
    }
}
