class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twen = 0;
        for(int b: bills) {
            if(b == 5) {
                five++;
            } else if(b == 10) {
                if(five == 0) return false;
                five--;
                ten++; 
            } else {
                if(ten > 0 && five > 0) {
                    ten--;
                    five--;
                    twen++;
                } else if(five >= 3) {
                    five -= 3;
                    twen++;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}