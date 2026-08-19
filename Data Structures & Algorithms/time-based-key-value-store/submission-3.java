class TimeMap {
    // 一个key 对不同的时间戳 可以放不同的值
    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();
    // 给一个key，要能找到离给的时间戳最近的最新的value

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            TreeMap<Integer, String> tree = new TreeMap<>();
            tree.put(timestamp, value);
            map.put(key, tree);
        } else {
            map.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap<Integer, String> tree = map.get(key);
        Integer floor = tree.floorKey(timestamp);
        return floor == null ? "" : tree.get(floor);
    }
}
