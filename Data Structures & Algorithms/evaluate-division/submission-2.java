class Solution {
    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            map.computeIfAbsent(a, k -> new HashMap<>()).put(b, v);
            map.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / v);
        }
        double[] res = new double[queries.size()];
        int idx = 0;
        for(List<String> q: queries) {
            String a = q.get(0);
            String b = q.get(1);
            Set<String> visited = new HashSet<>();
            double v = f(map, a, b, visited);
            res[idx++] = v;
        }
        return res;
    }

    double f(Map<String, Map<String, Double>> map, String a, String b, Set<String> visited) {
        if(!map.containsKey(a) || !map.containsKey(b)) return -1.0;
        if(a.equals(b)) return 1.0;
        Map<String, Double> next = map.get(a);
        if(next.containsKey(b)) return next.get(b);
        visited.add(a);
        for(String k: next.keySet()) {
            if(visited.contains(k)) continue;
            double res = f(map, k, b, visited);
            if(res != -1.0) {
                return next.get(k) * res;
            }
        }
        return -1.0;
    }
}