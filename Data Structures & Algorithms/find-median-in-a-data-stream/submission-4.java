class MedianFinder {
    // 1 100 2 1000

    // 2 1 1

    // 100 1000

    PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        pq1.add(num);
        pq2.add(pq1.poll());
        if(pq1.size() < pq2.size()) {
            pq1.add(pq2.poll());
        }
    }
    
    public double findMedian() {
        if((pq1.size() + pq2.size()) % 2 == 0) {
            return (pq1.peek() + pq2.peek()) / 2.0;
        } else {
            return pq1.peek();
        }
    }
}