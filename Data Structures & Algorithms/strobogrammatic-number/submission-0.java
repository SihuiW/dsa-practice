class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        StringBuilder sb = new StringBuilder();
        for(char c: num.toCharArray()) {
            if(!map.containsKey(c)) return false;
            sb.append(map.get(c));
        }
        return num.equals(sb.reverse().toString());
    }
}
