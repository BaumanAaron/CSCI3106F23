
/**
 * ShortestPath2
 */
import java.util.*;

public class ShortestPath2_2 {
    static boolean debug = false; // for tracing

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();// number of nodes
            if (n == 0) {
                break;
            }
            int m = sc.nextInt();// number of edges
            int q = sc.nextInt();// number of queries
            int s = sc.nextInt();// source node

            // Creates array and Initializes n Vertex
            Vertex[] V = new Vertex[n];
            for (int i = 0; i < n; i++) {
                V[i] = new Vertex(i);
            }

            // Stores Edge Info
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int t0 = sc.nextInt();
                int delta_t = sc.nextInt();
                int w = sc.nextInt();

                V[u].adjacent.add(new Edge(V[v], t0, delta_t, w));
            }

            // Performs Dijkstra on the Graph
            dijkstra(V[s], null);

            // Gets Queried node and returns answer
            for (int i = 0; i < q; i++) {
                int Q = sc.nextInt();

                int shortestDist = V[Q].arriveTime;
                if (shortestDist == Integer.MAX_VALUE) {
                    System.out.println("Impossible");
                } else {
                    System.out.println(shortestDist);
                }
                // Call answer solver
            }
            // System.out.println();

        }

    }

    public static int next_Open(int curr, int t0, int P) {
        int open = -1;
        int i = 0;
        while (open < curr) {
            open = t0 + (i * P);
            i++;
        }

        return open;
    }

    public static void dijkstra(Vertex source, Vertex dest) {
        // argument dest is irrelvant if finding paths to all nodes
        source.arriveTime = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            if (debug)
                System.out.println("selected from queue node: " + u.name + "(" + u.arriveTime + ")");
            u.inTree = true;
            //if(u.arriveTime < )


            for (Edge e : u.adjacent) {
                Vertex v = e.to;
                int wait = e.next_aval(u.arriveTime);
                //System.out.println("wait: " + wait);
                //if (!v.inTree) {

                    if(wait == -1){
                        continue;
                    }

                    int at_v = u.arriveTime + wait + e.d;
                    //System.out.println("at_v: " + at_v);
                    if(v.arriveTime <= at_v){
                        continue;
                    }


                    int distToVthroughU = at_v;

                    if (distToVthroughU < v.arriveTime) {
                        vertexQueue.remove(v); // remove it to update priority and reinsert
                        v.arriveTime = distToVthroughU;
                        if (debug)
                            System.out.println(
                                    "       updating " + v.name + " to: " + v.arriveTime + " time: ");
                        vertexQueue.add(v);
                    }

                //}
            }
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        public int name;// name of node
        public List<Edge> adjacent;// stores list of connected nodes
        public boolean inTree;
        public int arriveTime = Integer.MAX_VALUE;// initial mindis

        public Vertex(int number) {
            this.name = number;
            inTree = false;
            adjacent = new ArrayList<>();
        }

        public Vertex(int number, Edge e) {
            this.name = number;
            adjacent.add(e);
        }

        @Override
        public int compareTo(Vertex other) {
            // TODO Auto-generated method stub

            return Integer.compare(this.arriveTime, other.arriveTime);
        }

    }

    public static class Edge {
        Vertex to;// Where the edge goes to
        int t0;// The first time the edge opens to travel on
        int P;// Interval after t0 that edge opens
        int d;// Time to travel the edge

        public Edge(Vertex to, int f, int s, int t) {
            this.to = to;
            this.t0 = f;
            this.P = s;
            this.d = t;
        }

        public int next_aval(int u_arrive){
            if(u_arrive <= this.t0){
                return this.t0-u_arrive;
            }
            if(this.P == 0){
                return -1;
            }
            int period = (int)Math.ceil(((double)u_arrive-(double)this.t0 ) / (double)this.P);
            return ((period * this.P)+  this.t0) - u_arrive;
        }

    }

}
