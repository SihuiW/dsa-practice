class Solution {
    // n辆车以不同的速度在不同位置向右开
    // 如果后面的车追上了前面的车 那他们就会以前车速度一起走 成为车流
    // 他们需要到共同的目的地
    // 问最后会形成多少个车流
    // 到目的地瞬间加入的也算
    // 需要先排序车辆位置 升序排序 然后算出他们到目的地需要的时间
    // 例如： 
    //  1 - （10 - 1）/ 3 = 3小时 
    //  2 -  （10 - 2）/ 2小时 = 4小时
    // 因此第一辆车会追上第二辆，形成车流

    public int carFleet(int target, int[] position, int[] speed) {
        
        double[][] cars = new double[speed.length][2];
        for(int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]) );

        Stack<Double> stk = new Stack<>();
        for(int i = cars.length - 1; i >= 0; i--) {
            // 先从终点最近的开始遍历 只要后面的车用时比它小 就会追上它 比它大跟不上它 就会形成新车流
            if(stk.isEmpty() || cars[i][1] > stk.peek()) {
                stk.push(cars[i][1]);
            }
        }
        return stk.size();
    }
}
