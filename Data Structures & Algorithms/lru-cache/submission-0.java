class LRUCache {

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            if(map.size() >= capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }
}
