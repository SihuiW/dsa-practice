class MyHashSet {
    List<Integer> list = new ArrayList<>();

    public MyHashSet() {

    }
    
    public void add(int key) {
        if(contains(key)) return;
        list.add(key);
    }
    
    public void remove(int key) {
        list.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */