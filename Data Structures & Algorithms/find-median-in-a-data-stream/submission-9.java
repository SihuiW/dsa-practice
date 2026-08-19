class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();


    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if(size % 2 == 0) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double)maxHeap.peek();
        }
    }
}
