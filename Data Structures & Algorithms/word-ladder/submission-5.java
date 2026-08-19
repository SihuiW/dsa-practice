class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        if(!dic.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] temp = cur.toCharArray();
                for(int j = 0; j < temp.length; j++) {
                    char c = temp[j];
                    for(int k = 0; k < 26; k++) {
                        temp[j] = (char)('a' + k);
                        String s = new String(temp);
                        if(s.equals(endWord)) {
                            return res + 1;
                        }
                        if(dic.contains(s) && !visited.contains(s)) {
                            visited.add(s);
                            q.add(s);
                        }
                    }
                    temp[j] = c;
                }
            }
            res++;
        }

        return 0;
    }
}