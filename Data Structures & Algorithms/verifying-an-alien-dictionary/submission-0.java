class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        List<Character> alp = new ArrayList<>();
        for(char c: order.toCharArray()) {
            alp.add(c);
        }
        for(int i = 0; i < words.length - 1; i++) { 
                String word1 = words[i];
                String word2 = words[i + 1];
                boolean findDif = false;
                int l = Math.min(word1.length(), word2.length());
            for(int j = 0; j < l; j++) {
                
                if(word1.charAt(j) != word2.charAt(j)) {
                    findDif = true;
                    if(alp.indexOf(word1.charAt(j)) > alp.indexOf(word2.charAt(j))) {
                        return false;
                    }
                    break;

                }
            }
            if(!findDif && word1.length() > word2.length()) return false;
        }
        return true;
    }
}