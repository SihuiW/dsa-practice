class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            boolean destroyed = false;
            while(!stk.isEmpty() && stk.peek() > 0 && asteroids[i] < 0) {
                if(stk.peek() < -asteroids[i]) {
                    stk.pop();
                } else if (stk.peek() == -asteroids[i]) {
                    stk.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                stk.push(asteroids[i]);
            }
        }


        int[] res = new  int[stk.size()];
        int index = 0;
        for(int n: stk) {
            res[index++] = n;
        }
        return res;
    }
}