class Solution {
    public static int[][] rotate(int[][] oldKey){
        int n = oldKey.length;
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[j][n-i-1] = oldKey[i][j];
            }
        }
        return result;
    }
    
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int[][] newLock = new int[n*3][n*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                newLock[i+n][j+n] = lock[i][j]; 
            }
        }
        
        for(int dir = 0;dir<4;dir++){
            //시계 방향 90도 회전
            key = rotate(key);
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    //열쇠 넣기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }
                    if (check(newLock)) return true;
                    //열쇠 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
}
