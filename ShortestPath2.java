
/**
 * ShortestPath2
 */
import java.util.*;

public class ShortestPath2 {
    static boolean debug = true; // for tracing

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

                int shortestDist = V[Q].minDis;
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

    public static void dijkstra(Vertex source, Vertex dest) {
        // argument dest is irrelvant if finding paths to all nodes
        source.minDis = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            if (debug)
                System.out.println("selected from queue node: " + u.name + "(" + u.minDis + ")");
            u.inTree = true;
            if (u == dest)
                return; // commented ==> find paths to all nodes

            for (Edge e : u.adjacent) {
                Vertex v = e.to;
                if (!v.inTree) {
                    if (debug)
                        System.out.println("    adj: " + v.name + "(" + v.minDis + ")");
                    for (int time = u.minDis; time < 3000; time++) {
                        if (e.P == 0 ) {
                            // When P = 0
                            if (time == e.t0) {
                                int distToVthroughU = time+e.d;
                                
                                if (distToVthroughU < v.minDis) {
                                    vertexQueue.remove(v); // remove it to update priority and reinsert
                                    v.minDis = distToVthroughU;
                                    if (debug)
                                        System.out.println("       updating p=0 " + v.name + " to: " + v.minDis);
                                    vertexQueue.add(v);
                                }
                                break;
                            }
                        } else {
                            // Through Multiple nodes
                            if (time >= e.t0 && (((time - e.t0) % e.P) == 0)) {
                                int distToVthroughU = e.d + time;
                                
                                if (distToVthroughU < v.minDis) {
                                    vertexQueue.remove(v); // remove it to update priority and reinsert
                                    v.minDis = distToVthroughU;
                                    if (debug)
                                        System.out.println("       updating through 2 " + v.name + " to: " + v.minDis + " time: "+time);
                                    vertexQueue.add(v);
                                }
                                
                            }
                        
                            
                        }

                    }
                }
            }
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        public int name;// name of node
        public List<Edge> adjacent;// stores list of connected nodes
        public boolean inTree;
        public int minDis = Integer.MAX_VALUE;// initial mindis

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

            return Integer.compare(this.minDis, other.minDis);
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
    }

}
