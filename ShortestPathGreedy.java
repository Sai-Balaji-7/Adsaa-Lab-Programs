public class ShortestPathGreedy{
    static final int INF=999999999;
    //Greedy Single Source Shortest Path
    public static void shortestPath(int v,int[][]cost,int[] dist,int n){
        boolean[] S=new boolean[n];//S[i]=true if vertex is finalized
        for(int i=0;i<n;i++){
            S[i]=false;
            dist[i]=cost[v][i];
        }
        S[v]=true;//source is included
        dist[v]=0;
        for(int num=1;num<=n-1;num++){
            //choose u such that dist[u] is minimum and not in S
            int u=-1;
            int min=INF;
            for(int i=0;i<n;i++){
                if(!S[i]&&dist[i]<min){
                    min = dist[i];
                    u=i;
                }
            }
            //include u in s 
            S[u]=true;
            //updating the distances of vertices from adjacent to u
            for(int w=0;w<n;w++){
                if(!S[w]&&cost[u][w]!=INF){
                    if(dist[w]>dist[u]+cost[u][w]){
                        dist[w]=dist[u]+cost[u][w];
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        int n=5;
        int[][] cost={
            {0,10,INF,30,100},
            {INF,0,50,INF,INF},
            {INF,INF,0,INF,10},
            {INF,INF,20,0,60},
            {INF,INF,INF,INF,0}
        };
        int source=0;
        int[] dist=new int[n];
        shortestPath(source,cost,dist,n);
        System.out.println("Shortest distances from source vertex "+source+":");
        for(int i=0;i<n;i++){
            System.out.println("To vertex "+i+": "+dist[i]);
        }
    }

}