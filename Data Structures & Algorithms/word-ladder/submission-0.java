class Solution {
    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int n = wordList.size();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (diffOne(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int steps = 1;

        int beginIdx = wordList.indexOf(beginWord);
        if (beginIdx != -1) {
            dfs(wordList, graph, beginIdx, endWord, steps, visited);
        }

        for (int i = 0; i < n; i++) {
            if (diffOne(beginWord, wordList.get(i))) {
                visited.clear();
                visited.add(i);
                dfs(wordList, graph, i, endWord, steps + 1, visited);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private void dfs(List<String> wordList, List<Integer>[] graph, 
                     int currIdx, String endWord, int steps, Set<Integer> visited) {
        String curr = wordList.get(currIdx);

        if (curr.equals(endWord)) {
            res = Math.min(res, steps);
            return;
        }

        if (steps >= res) return;

        for (int nextIdx : graph[currIdx]) {
            if (!visited.contains(nextIdx)) {
                visited.add(nextIdx);
                dfs(wordList, graph, nextIdx, endWord, steps + 1, visited);
                visited.remove(nextIdx);
            }
        }
    }

    private boolean diffOne(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}