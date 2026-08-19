class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(map.containsKey(email)) {
                    uf.union(map.get(email), i);
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> mailGroup = new HashMap<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String e = entry.getKey();
            int a = entry.getValue();
            int leader = uf.find(a);
            mailGroup.putIfAbsent(leader, new ArrayList<>());
            mailGroup.get(leader).add(e);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: mailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(accId).get(0));
            temp.addAll(emails);
            res.add(temp);
        } 
        return res;

    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x1, int x2) {
            int p1 = find(x1);
            int p2 = find(x2);
            if(p1 == p2) return false;
            if(rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
            return true;
        }
    }
}