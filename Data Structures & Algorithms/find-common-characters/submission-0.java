class Solution {
    public List<String> commonChars(String[] words) {
        int[] record = new int[26];
        for(char c: words[0].toCharArray()) {
            record[c - 'a']++;
        }
        for(int i = 1; i < words.length; i++) {
            int[] curRecord = new int[26];
            for(char c: words[i].toCharArray()) {
                curRecord[c - 'a']++;
            }
            for(int j = 0; j < 26; j++) {
                record[j] = Math.min(record[j], curRecord[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < record[i]; j++) {
                res.add("" + (char)(i + 'a'));
            }
        }
        
        return res;

    }
}