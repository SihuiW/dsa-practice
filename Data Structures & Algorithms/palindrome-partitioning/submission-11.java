class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        f(s, new ArrayList<>(), 0);
        return res;
    }

    void f(String s, List<String> list, int idx) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            if(isP(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                f(s, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isP(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }



}
