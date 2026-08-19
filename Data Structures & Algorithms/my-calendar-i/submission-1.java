class MyCalendar {

    TreeSet<int[]> tree = new TreeSet<>((a,b) -> a[0] - b[0]);

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        int[] event = new int[]{startTime, endTime};
        int[] prev = tree.floor(event);
        int[] next = tree.ceiling(event);
        if((prev != null && prev[1] > event[0]) || (next != null && next[0] < event[1])) return false;
        tree.add(event);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */