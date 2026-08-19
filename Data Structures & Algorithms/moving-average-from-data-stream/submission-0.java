class MovingAverage {

    int size;
    Queue<Integer> q;
    int sum;

    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        q.add(val);
        if(q.size() > size ) {
            sum -= q.poll();
            return(double)sum / size;
        } else {
            return (double) sum / q.size();
        }
        

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
