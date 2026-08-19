class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        for(String w: words) {
            for(int i = 0; i < words.length; i++) {
                if(w.equals(words[i])) continue;
                if(w.contains(words[i])) res.add(words[i]);
            }
        }
        return new ArrayList<>(res);
    }
}