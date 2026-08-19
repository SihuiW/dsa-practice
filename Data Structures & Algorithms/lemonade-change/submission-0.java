class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int b: bills) {
            q.offer(b);
        }

        while(!q.isEmpty()) {
            int bill = q.poll();
            if(bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                fiveCount--;
                tenCount++;
                if(fiveCount < 0) return false;
            } else {
                if(tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    if(fiveCount > 2) {
                        fiveCount -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;

    }
}