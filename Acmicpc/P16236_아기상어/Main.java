import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int size;
		int d;    //상어로 부터 거리
		
		public Fish() {
		}
		
		public Fish(int r, int c, int size, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.d = distance;
		}

		@Override
        public int compareTo(Fish f) {
            int rr=Integer.compare(this.d, f.d);
            if(rr==0){
                int u=Integer.compare(this.r, f.r);
                if(u==0){
                    return Integer.compare(this.c, f.c);
                }else return u;
            }else return rr;
        }

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", distance=" + d + "]";
		}
	
	}
	public static class Shark{
		int r; //행
		int c; //열
		int size; //크기
		int qunt; //량
		int time; //시간
		public Shark(int r, int c, int size, int qunt, int time) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			if(size==qunt){ //먹는 량에 따라서 자동으로 사이즈 키워주기
				this.size++;
				this.qunt = 0;
			}else{
				this.qunt = qunt;
			}
			
			this.time = time;
		}
		public Shark() {
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", size=" + size + ", qunt=" + qunt + ", time=" + time + "]";
		}
	}
	static int N;
	static int [][] map;
	static int [][] v;
	static List<Fish> fishq=new ArrayList<Fish>();
	static ArrayList<Fish> ff=new ArrayList<>();
	static Shark shark;
	static int cnt;
	
	static int[] dr={-1,0,0,1};
	static int[] dc={0,-1,1,0};
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==9){
					shark=new Shark(i,j,2,0,0);
				}
			}
		}
		cnt=0;
		bfs(); //dfs()안에서 bfs()를 쓰겠다.
		System.out.println(cnt);
	}
	
	private static int distance(int sr, int sc, int er, int ec, int size){
		int[][] b=new int[N][N];
		Queue<Fish> que=new LinkedList<>();
		que.offer(new Fish(sr,sc, size,0));
		b[sr][sc]=1;
		while(!que.isEmpty()){
			Fish cf=que.poll();
			int cr=cf.r;
			int cc=cf.c;
			int csize=cf.size;
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				
				if(!check(nr,nc) ){continue; }
				if(b[nr][nc]==0 && (csize>=map[nr][nc])){
					if(er==nr && ec==nc){ 
						return b[cr][cc];
					}
					
					b[nr][nc]=b[cr][cc]+1;
					que.offer(new Fish(nr,nc,csize,0));
				}
			}
		}//
		// 갈수 없을 경우 중요
		return -1;
	}
	private static void bfs() {
		//현재 상태의 물고기 저장
		fishq.clear(); //싹지워
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>0 && map[i][j]<7){
					//모든 물고기
					fishq.add(new Fish(i,j,map[i][j],0));
				}
			}
		}
		//저장된 물고기에서
		//상어가 먹을 수 있는 물고기
		//거리 -->, 위치 물고기
		//가장 가까운것 > bfs()
		ff.clear();
		for (int i = 0; i < fishq.size(); i++) {
			Fish sfish=fishq.get(i);  // 물고기를 하나씩4 가져와서 
			if(sfish.size<shark.size){ // 상어보다 작은 물고기이면 
				// 상어부터 물고기 거리 까지 거리를 구한다.
				// 갈수 없다면 -1
				int kk=distance(shark.r, shark.c, sfish.r, sfish.c, shark.size);
				if(kk!=-1){  // 갈수 있을 경우 막힌 경우를 고려안했기 때문에
					sfish.d=kk;//distance(shark.r, shark.c, sfish.r, sfish.c, shark.size);
					ff.add(sfish);
				}
			}
		}
		//거리에 먹을 수 있는 물고기가 존재
		if(ff.size()==0){
			return ;
		}else{
			//물고기가 같은 거리 여러개 -> 상 오
			Collections.sort(ff);
			Fish tfish=ff.get(0);
			int distance=tfish.d;
			int tr=tfish.r;
			int tc=tfish.c;
			int sr=shark.r;
			int sc=shark.c;
			shark=new Shark(tr, tc, shark.size, shark.qunt+1, shark.time+distance);
			map[sr][sc]=0;
			map[tr][tc]=9;
			cnt=shark.time;
			bfs();
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N){return true;
		}else return false;
	}
}
