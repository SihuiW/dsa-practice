class Solution {
    public boolean isPathCrossing(String path) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('N', new int[]{-1, 0});
        map.put('S', new int[]{1, 0});
        map.put('E', new int[]{0, 1});
        map.put('W', new int[]{0, -1});
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(x + "," + y);
        for(char c: path.toCharArray()) {
            x += map.get(c)[0];
            y += map.get(c)[1];
            String pos = x + "," + y;
            if(set.contains(pos)) return true;
            set.add(pos);
        }
        return false;
    }
}