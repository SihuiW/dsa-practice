class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while(!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll();
            int di = d.poll();
            if(ri < di) {
                r.add(ri + senate.length());
            } else {
                d.add(di + senate.length());
            }
        }

        return r.isEmpty()? "Dire" : "Radiant";
    }
}