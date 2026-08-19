class MedianFinder {

    PriorityQueue<Integer> p1 = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> p2 = new PriorityQueue<>((a, b) -> a - b);
    int size;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        p1.add(num);
        p2.add(p1.poll());
        if(p2.size() > p1.size() + 1) {
            p1.add(p2.poll());
        }

        size++;
    }
    
    public double findMedian() {
        if(size % 2 != 0) {
            return (double)p2.peek();
        }
        return (double)(p1.peek() + p2.peek()) / 2;
    }

}