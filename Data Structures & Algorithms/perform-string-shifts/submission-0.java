class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            dq.offerLast(c);
        }
        for(int i = 0; i < shift.length; i++) {
            int d = shift[i][0];
            int a = shift[i][1];
            if(d == 0) {
                while(a > 0) {
                    char c = dq.pollFirst();
                    dq.offerLast(c);
                    a--;
                }
            } else {
                while(a > 0) {
                    char e = dq.pollLast();
                    dq.offerFirst(e);
                    a--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}
