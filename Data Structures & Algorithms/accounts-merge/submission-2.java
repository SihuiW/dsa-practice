class Solution {
    class UF {
        Map<String, String> parent = new HashMap<>();

        public UF(List<List<String>> accounts) {
            for (List<String> list : accounts) {
                for (int i = 1; i < list.size(); i++) {
                    parent.put(list.get(i), list.get(i));
                }
            }
        }

        String find(String a) {
            if (!parent.get(a).equals(a)) {
                parent.put(a, find(parent.get(a)));
            }
            return parent.get(a);
        }

        boolean union(String a, String b) {
            String ra = find(a);
            String rb = find(b);
            if (ra.equals(rb))
                return false;
            parent.put(rb, ra);
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF(accounts);
        Map<String, String> emailToName = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                emailToName.put(list.get(i), name);
            }
            String r = list.get(1);
            for(int i = 2; i < list.size(); i++) {
                uf.union(r, list.get(i));
            }
        }

        Map<String, List<String>> group = new HashMap<>();
        for(String email: uf.parent.keySet()) {
            String r = uf.find(email);
            group.computeIfAbsent(r, k -> new ArrayList<>()).add(email);
        }


        for(String root: group.keySet()) {
            String name = emailToName.get(root);
            List<String> list = new ArrayList<>();
            list.add(name);
            Collections.sort(group.get(root));
            for(String email: group.get(root)) {
                list.add(email);
            }
            res.add(new ArrayList<>(list));
        }

        return res;
        
        
    }
}