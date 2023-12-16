import java.util.*;

public class FeastForCats {
    /**
     * @param args
     */
    static boolean debug = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int h = 0; h < t; h++) {

            int M = sc.nextInt();
            int C = sc.nextInt();
            int counter = (C * (C - 1)) / 2;

            cats[] f = new cats[M];
            for (int i = 0; i < C; i++) {
                f[i] = new cats(i);
                // System.out.println("cat #:"+i);
            }

            for (int i = 0; i < counter; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int d = sc.nextInt();
                f[u].catdist.add(new Edge(v, d));
                f[v].catdist.add(new Edge(u, d));
                // System.out.println(i);

            }
            int dist_travel = Prim(f[0], C, f);

            if (dist_travel + C<= M) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static int Prim(cats cat0, int nodes, cats[] allcats) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        List<Edge> MST = new ArrayList<>();
        int meters = 0;
        for (int i = 0; i < cat0.catdist.size(); i++) {
            pq.add(cat0.catdist.get(i));
        }
        cat0.inTree = true;

        // for (Edge edge : pq) {
        // System.out.println("To: "+edge.o_cat + " Meters: " + edge.dist);
        // }

        while (MST.size() < nodes - 1) {

            Edge min = pq.poll();
            if (debug)
                System.out.println("Current Edge To: " + min.o_cat + " Meters: " + min.dist);
            cats v = allcats[min.o_cat];
            if (debug)
                System.out.println("Cat: " + v.name);
            if (v.inTree == false) {
                MST.add(min);
                v.inTree = true;
                if (debug)
                    System.out.println("MST Edge---- \nTo: " + min.o_cat + "\nMeters: " + min.dist);
                meters += min.dist;
                for (int i = 0; i < v.catdist.size(); i++) {
                    pq.add(v.catdist.get(i));
                }
            }

        }

        return meters;

    }

    static class cats {
        int name;
        public ArrayList<Edge> catdist;
        boolean inTree;

        public cats(int name) {
            this.name = name;
            catdist = new ArrayList<>();
            inTree = false;
        }

        public cats(int name, int ocat, int dist) {
            this.name = name;
            catdist.add(new Edge(ocat, dist));
            inTree = false;
        }
    }

    static class Edge implements Comparable<Edge> {
        int o_cat;
        int dist;

        public Edge(int o, int d) {
            this.o_cat = o;
            this.dist = d;
        }

        public int compareTo(Edge that) {
            return this.dist - that.dist;
        }

    }
}
