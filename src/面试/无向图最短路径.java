package 面试;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 无向图最短路径 {
        private static final int MAX_VERTEX = 100005;
        private static final int MAX_EDGE = 200005;
        private static final int INF = Integer.MAX_VALUE;
        private int[] head = new int[MAX_VERTEX];
        private int[] visited = new int[MAX_VERTEX];
        private int[] dist = new int[MAX_VERTEX];
        private int cnt = 0;
        private static class edge{
                //指向下一个的点
                int  to;
                int weight;
                //与这条边起点相同的上一条边的序号
                int next;
        }
        private static class node{
                int sequence;
                int distance;
                public node(int sequence,int distance){
                        this.sequence = sequence;
                        this.distance = distance;
                }
        }
        edge[] e = new edge[MAX_EDGE];
        public void add(int u,int v,int w){
                cnt++;
                e[cnt].to = v;
                e[cnt].weight = w;
                e[cnt].next = head[u];
                head[u] = cnt;
                cnt++;
                e[cnt].to = u;
                e[cnt].weight = w;
                e[cnt].next = head[v];
                head[v] = cnt;
        }

        /***
         *
         * @param v0 源点
         * @param n  点的总数
         */
        public void dijkstra_heap(int v0,int n){
                PriorityQueue<node> priorityQueue = new PriorityQueue<>(new Comparator<node>() {
                        @Override
                        public int compare(node o1, node o2) {
                                return o1.distance-o2.distance;
                        }
                });
                for(int i=1;i<=n;i++)
                        visited[i] = 0;
                for(int i=1;i<=n;i++)
                        dist[i] = INF;
                dist[v0] = 0;
                priorityQueue.offer(new node(v0,0));
                while (!priorityQueue.isEmpty()){
                        node tem = priorityQueue.poll();
                        int u1 = tem.sequence;
                        if(visited[u1] == 1)
                                continue;
                        visited[u1] = 1;
                        for(int i=head[u1];i!=0;i=e[i].next){
                                int sn1 = e[i].to;
                                if(dist[u1]+e[i].weight<dist[sn1]){
                                        dist[sn1] = dist[u1]+e[i].weight;
                                        if(visited[sn1] == 0)
                                                priorityQueue.offer(new node(sn1,dist[sn1]));
                                }
                        }
                }
        }
}
