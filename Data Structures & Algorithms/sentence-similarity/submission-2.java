class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        Set<String> set = new HashSet<>();
        for(List<String> list: similarPairs) {
            set.add(list.get(0) + "#" + list.get(1));
            set.add(list.get(1) + "#" + list.get(0));
        }
        for(int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if (w1.equals(w2)) continue;
            if (!set.contains(w1 + "#" + w2)) return false;
        }
        return true;
    }
}