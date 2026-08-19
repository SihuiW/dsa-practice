class Solution {
    public int calculateTime(String keyboard, String word) {
        int times = 0;
        int prev = 0;
        for(char c: word.toCharArray()) {
            int idx = keyboard.indexOf(c);
            times += Math.abs(prev - idx);
            prev = idx;
        }
        return times;
    }
}
