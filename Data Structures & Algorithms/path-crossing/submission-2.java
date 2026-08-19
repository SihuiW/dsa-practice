class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        set.add("" + x + "to" + y);
        for(char p: path.toCharArray()) {
            if(p == 'N') {
                x++;
            }
            if(p == 'S') {
                x--;
            }
            if(p == 'E') {
                y++;
            }
            if(p == 'W') {
                y--;
            }
            if(set.contains("" + x + "to" + y)) return true;
            set.add("" + x + "to" + y);
        }
        return false;
    }
}