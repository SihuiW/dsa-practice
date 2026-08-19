class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(String o: operations) {
            if(o.equals("D")) {
                int pre = list.get(list.size() - 1);
                list.add(pre * 2);
            } else if(o.equals("+")) {
                int prev = list.get(list.size() - 1) + list.get(list.size() - 2);
                list.add(prev);
            } else if(o.equals("C")) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.valueOf(o));
            }
        }
        for(int e: list) {
            res += e;
        }
        return res;
    }
}