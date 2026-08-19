class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for(String d: details) {
            String age = d.substring(11, 13);
            int a = Integer.valueOf(age);
            if(a > 60) res++;
        }
        return res;
    }
}