import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        private int dist;
        private int nodeA;
        private int nodeB;
        public Edge(int dist, int nodeA, int nodeB){
            this.dist = dist;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
        public int getDist(){
            return dist;
        }
        public int getNodeA(){
            return nodeA;
        }
        public int getNodeB(){
            return nodeB;
        }
        @Override
        public int compareTo(Edge other){
            if(this.dist < other.dist){
                return -1;
            }
            return 1;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Edge> graph = new ArrayList<Edge>();
        int[] parents = new int[n]; //부모 배열
        //부모배열 초기화
        for(int i = 0;i<parents.length;i++){
            parents[i] = i;
        }
        for(int j = 0;j<costs.length; j++){
            graph.add(new Edge(costs[j][2],costs[j][0],costs[j][1]));
        }
        //크루스칼을 하기 위한 정렬
        Collections.sort(graph);
        
        for(int k = 0; k<graph.size(); k++){
            int a = graph.get(k).getDist();
            int b = graph.get(k).getNodeA();
            int c = graph.get(k).getNodeB();
            if(find(b,parents) != find(c,parents)){
                union(b,c,parents);
                answer += a;
            }
        }
        
        return answer;
    }
    private void union(int a,int b,int[] parents){
        a = find(a,parents);
        b = find(b,parents);
        if(a < b){
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }
    private int find(int a,int[] parents){
        if(a == parents[a]){
            return a;
        }
        return find(parents[a],parents);
    }
}
