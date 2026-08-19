class LRUCache {
    LinkedHashMap<Integer,Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(128,0.75f,true) {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
