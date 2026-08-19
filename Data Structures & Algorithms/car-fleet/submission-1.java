class Solution {
    class Car {
        int pos;
        int speed;
        public Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (a,b) -> b.pos - a.pos);

        Stack<Double> stk = new Stack<>();
        for(Car car: cars) {
            double time = (double) (target - car.pos) / car.speed;
            if(stk.isEmpty() || time > stk.peek()) {
                stk.push(time);
            }
        }
        return stk.size();
    }
}
