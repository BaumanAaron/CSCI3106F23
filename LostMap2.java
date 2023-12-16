import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LostMap2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[][] adj_list = new int[n][n];
        village[] map = new village[n];
        //Try taking away the +1 and just add one to the answers
        for (int i = 0; i < n; i++) {
            map[i] = new village(i);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj_list[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        br.close();

        // System.out.println("----------------------------------");
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(adj_list[i][j] + " ");
        // }
        // System.out.println();
        // }

        PriorityQueue<path> pq = new PriorityQueue<path>();

        // Add paths from village to village to ArrayList
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                map[i].Paths.add(new path(i, j, adj_list[i][j]));
                pq.add(new path(i, j, adj_list[i][j]));
                

            }

        }

        Kruskal(map, pq, n);

    }

    public static void Kruskal(village[] map, PriorityQueue<path> pq, int n) {
        List<Pair> MST = new ArrayList<>();

        // Adds all edges to PriorityQueue
        path first = pq.poll();

        // Adds First edge to MST
        map[first.u_village].inMap = true;
        map[first.v_village].inMap = true;

        MST.add(new Pair(first.u_village, first.v_village));

        while (MST.size() != (n - 1)) {
            path current_path = pq.poll();

            // Only Case when you dont add the edge to the MST
            if (!(map[current_path.v_village].inMap == true && map[current_path.u_village].inMap == true)) {

                // Adds edge to MST
                MST.add(new Pair(current_path.u_village, current_path.v_village));

                // Make both villages inMap
                map[current_path.v_village].inMap = true;
                map[current_path.u_village].inMap = true;
            }
        }

        // Print Out Answer
        Collections.sort(MST);
        for (Pair pair : MST) {
            System.out.println((pair.x+1) + " " + (pair.y+1));
        }

    }
}

class village {
    int village;
    ArrayList<path> Paths;
    boolean inMap;

    village(int uv) {
        this.village = uv;
        this.Paths = new ArrayList<>();
        this.inMap = false;
    }

    village(int uv, int vv, int d) {
        this.village = uv;
        this.Paths.add(new path(uv, vv, d));
        this.inMap = false;
    }
}

class path implements Comparable<path> {
    int u_village;
    int v_village;
    int distance;

    path(int u, int v, int d) {
        this.u_village = u;
        this.v_village = v;
        this.distance = d;
    }

    @Override
    public int compareTo(path that) {
        return this.distance - that.distance;
    }
}

class Pair implements Comparable<Pair> {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        // Compare by x first
        int compareResult = Integer.compare(this.x, other.x);

        // If x values are equal, compare by y
        if (compareResult == 0) {
            compareResult = Integer.compare(this.y, other.y);
        }

        return compareResult;
    }
}
