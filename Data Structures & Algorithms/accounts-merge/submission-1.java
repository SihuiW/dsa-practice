class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                uf.union(firstEmail, email);
                emailToName.put(email, name);
            }
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String email : uf.parent.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> list = new ArrayList<>();
            list.add(emailToName.get(root));
            list.addAll(emails);

            res.add(list);
        }

        return res;
    }

    class UF {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        void add(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 1);
            }
        }

        String find(String x) {
            add(x);

            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }

            return parent.get(x);
        }

        boolean union(String a, String b) {
            String ap = find(a);
            String bp = find(b);

            if (ap.equals(bp)) return false;

            if (rank.get(ap) > rank.get(bp)) {
                parent.put(bp, ap);
                rank.put(ap, rank.get(ap) + rank.get(bp));
            } else {
                parent.put(ap, bp);
                rank.put(bp, rank.get(bp) + rank.get(ap));
            }

            return true;
        }
    }
}