class Solution {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (map[b - 'a'] - map[a - 'a']));

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.offer((char) ('a' + i));
            }
        }

        char prev = ' ';
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char cur = pq.poll();
            sb.append(cur);
            if (prev != ' ' && map[prev - 'a'] != 0) {
                pq.offer(prev);
            }
            map[cur - 'a']--;
            prev = cur;
        }

        if (sb.length() != s.length()) return "";
        return sb.toString();
    }
}