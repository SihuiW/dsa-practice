class Solution {
    // 把s1的字母和数量放到map里
    // window里面放当前滑动窗口内的字符及其出现次数（所有字符）
    // 所有字符都放到window里，right++
    // 如果这个字母在need中且数量等于need里这个字母的数量 valid++
    // 一旦valid = need的长度 就返回true
    // 缩小窗口时刻：窗口长度超过s1长度就要缩小
    // left指向的字符要从窗口里删掉，如果是need中的字符且删除前数量=need中数量，valid--
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        for(char c: s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while(right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(need.containsKey(c) && window.get(c).equals(need.get(c))) {
                valid++;
            }
            while((right - left) >= s1.length()) {
                if(valid == need.size()) return true;
                char d = s2.charAt(left);
                left++;
                
                if(need.containsKey(d) && window.get(d).equals(need.get(d))) {
                    valid--;
                }

                window.put(d, window.get(d) - 1);
            }
        }

        return false;

    }
}
