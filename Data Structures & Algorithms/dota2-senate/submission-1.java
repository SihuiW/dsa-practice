class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();

        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                R.add(i);
            } else {
                D.add(i);
            }
        }

        while(!R.isEmpty() && !D.isEmpty()) {
            int a = R.poll();
            int b = D.poll();
            if(a < b) {
                R.add(a + senate.length());
            } else {
                D.add(b + senate.length());
            }
        }

        return R.isEmpty() ? "Dire" : "Radiant";
    }
}