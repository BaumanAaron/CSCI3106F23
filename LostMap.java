import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LostMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[][] adj_list = new int[n][n];
        village[] map = new village[n];
        // Try taking away the +1 and just add one to the answers
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
            for (int j = i + 1; j < n; j++) {
                map[i].Paths.add(new path(i, j, adj_list[i][j]));
                pq.add(new path(i, j, adj_list[i][j]));

            }

        }

        Kruskal(map, pq, n);

    }

    public static void Kruskal(village[] map, PriorityQueue<path> pq, int n) {
        List<Pair> MST = new ArrayList<>();
        UnionFind.UF uf = new UnionFind.UF(n);

        while (MST.size() != (n - 1)) {
            path current_path = pq.poll();

            if (!uf.isSameSet(current_path.v_village, current_path.u_village)) {
                MST.add(new Pair(current_path.u_village, current_path.v_village));
                uf.unionSet(current_path.u_village, current_path.v_village);
            }
        }

        Collections.sort(MST);
        for (Pair pair : MST) {
            System.out.println((pair.x + 1) + " " + (pair.y + 1));
        }
    }
}

class village {
    int set;
    int village;
    ArrayList<path> Paths;
    boolean inMap;

    village(int uv) {
        this.set = uv;
        this.village = uv;
        this.Paths = new ArrayList<>();
        this.inMap = false;
    }

    village(int uv, int vv, int d) {
        this.set = uv;
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

// union-find disjoint set
class UnionFind {
    static class UF {
        private Vector<Integer> p, rank, setSize;
        private int numSets;

        public UF(int N) {
            p = new Vector<Integer>(N);
            rank = new Vector<Integer>(N);
            setSize = new Vector<Integer>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i)
                return i;
            else {
                int ret = findSet(p.get(i));
                p.set(i, ret);
                return ret;
            }
        }

        // return true if element i and j are in the same set, return false otherwise
        public Boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        // union two sets that contain element i and j
        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) {
                    p.set(y, x);
                    setSize.set(x, setSize.get(x) + setSize.get(y));
                } else {
                    p.set(x, y);
                    setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y))
                        rank.set(y, rank.get(y) + 1);
                }
            }
        }

        // return number of disjoint sets
        public int numDisjointSets() {
            return numSets;
        }

        // return the size of the set that contain element i
        public int sizeOfSet(int i) {
            return setSize.get(findSet(i));
        }
    }
}
