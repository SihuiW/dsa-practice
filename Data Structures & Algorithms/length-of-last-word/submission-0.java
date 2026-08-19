class Solution {
    public int lengthOfLastWord(String s) {
        String ns = s.strip();
        String[] ss = ns.split(" ");
        return ss[ss.length - 1].length();
    }
}