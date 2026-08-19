class Solution {
    // 把s1的字母和数量放到map里
    // window里面放字母和数量
    // 如果s1包含这个字母 那就把它放到window里，right++
    // 如果这个字母的数量等于map里面这个字母的数量 valid++
    // 一旦valid = map的长度 就返回true
    // 缩小窗口时刻：窗口长度超过s1长度就要缩小
    // left指向的这个数要从窗口里删掉 如果是这个字母的数量= s1字母的数量 valid--;
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
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while((right - left) >= s1.length()) {
                if(valid == need.size()) return true;
                char d = s2.charAt(left);
                left++;
                
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;

    }
}
