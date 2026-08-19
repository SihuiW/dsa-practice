class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);

        int len = beginWord.length();
        int steps = 1;

        while (!begin.isEmpty() && !end.isEmpty()) {
            // 总是扩展较小的一侧
            if (begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }

            Set<String> next = new HashSet<>();
            for (String word : begin) {
                char[] ch = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        ch[i] = c;
                        String nei = new String(ch);

                        if (end.contains(nei)) return steps + 1;
                        if (wordSet.contains(nei)) {
                            next.add(nei);
                            wordSet.remove(nei);
                        }
                    }
                    ch[i] = old;
                }
            }
            begin = next;
            steps++;
        }
        return 0;
    }
}