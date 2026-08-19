class Solution {
    public List<Integer> partitionLabels(String s) {
        //记录每一个字母最后的位置
        //从第一个开始更新最远端 直到到达那里 记录+1
        List<Integer> list = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int p = 0;
        int far = 0;
        int start = 0;
        while(p < s.length()) {
            far = Math.max(far, map.get(s.charAt(p)));
            if(p == far) {
                list.add(far - start + 1);
                start = p + 1;
            }
            p++;
        }
        return list;

    }
}
