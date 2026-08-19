class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for(int i = 1; i < folder.length; i++) {
            if(folder[i].startsWith(res.get(res.size() - 1) + "/")) {
                continue;
            }
            res.add(folder[i]);
        }

        return res;
    }
}