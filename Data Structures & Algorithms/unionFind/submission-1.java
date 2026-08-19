class UnionFind {

    int[] parents;
    int[] ranks;
    int numCom;

    public UnionFind(int n) {
        parents = new int[n];
        ranks = new int[n];
        numCom = n;
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        if(parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public boolean isSameComponent(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if(xp == yp) return true;
        return false;
    }

    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if(xp == yp) return false;
        if(ranks[xp] < ranks[yp]) {
            parents[xp] = yp;
            ranks[yp] += ranks[xp];
        } else {
            parents[yp] = xp;
            ranks[xp] += ranks[yp];
        }
        numCom--;
        return true;

    }

    public int getNumComponents() {
        return numCom;
    }
}
