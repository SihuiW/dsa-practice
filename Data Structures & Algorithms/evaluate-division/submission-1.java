class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        UnionFind uf = new UnionFind();
        for(int i = 0; i < values.length; i++) {
            List<String> pair = equations.get(i);
            double value = values[i];
            uf.union(pair.get(0), pair.get(1), value);
        }
        int index = 0;
        for(List<String> q: queries) {
            String a = q.get(0);
            String b = q.get(1);
            if(!uf.parent.containsKey(a) || !uf.parent.containsKey(b)) {
                res[index++] = -1;
            } else if(uf.find(a) != uf.find(b)) {
                res[index++] = -1;
            } else {
                double value = uf.getWeight(b) / uf.getWeight(a);
                res[index++] = value;
            }
        }
        return res;
    }

    class UnionFind {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> weight = new HashMap<>();

        String find(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                weight.put(x, 1.0);
                return x;
            }

            if (!parent.get(x).equals(x)) {
                String oldParent = parent.get(x);
                String root = find(oldParent);
                weight.put(x, weight.get(x) * weight.get(oldParent));
                parent.put(x, root);
            }
            return parent.get(x);
        }

        void union(String a, String b, double value) {
            String ra = find(a);
            String rb = find(b);

            if (ra.equals(rb)) {
                return;
            }

            parent.put(rb, ra);
            weight.put(rb, value * weight.get(a) / weight.get(b));
        }

        double getWeight(String x) {
            find(x);
            return weight.get(x);
        }
    }
}