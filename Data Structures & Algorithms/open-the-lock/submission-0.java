class Solution {
    public int openLock(String[] deadends, String target) {
        if(target == "0000") return 0;
        Set<String> dead = new HashSet<>();
        for(String d: deadends) {
            dead.add(d);
        }
        if(dead.contains("0000")) return -1;

        String start = "0000";
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        dead.add(start);
        int res = 0;

        while(!q.isEmpty()) {
            res++;
            for(int i = q.size(); i > 0; i--) {
                String s = q.poll();
                for(int j = 0; j < 4; j++) {
                    for(int turn: new int[]{1,-1}) {
                        char[] arr = s.toCharArray();
                        int cur = s.charAt(j) - '0';
                        cur = (cur + turn + 10) % 10;
                        arr[j] = (char)(cur + '0');
                        String next = new String(arr);
                        if(dead.contains(next)) continue;
                        if(next.equals(target)) return res;
                        q.offer(next);
                        dead.add(next);
                    }
                }
            }
            
        }
        return -1;

    }
}