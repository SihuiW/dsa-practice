class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        
    }

    public void addNum(int num) {
        right.add(num);
        left.add(right.poll());
        if(left.size() > right.size()) {
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        if((right.size() + left.size()) % 2 == 0) {
            return (right.peek() + left.peek()) / 2.0;
        } else {
            return (double)right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */