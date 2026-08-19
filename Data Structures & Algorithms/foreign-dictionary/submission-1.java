class Solution {
    StringBuilder sb = new StringBuilder();
    public String foreignDictionary(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();

        for(String word: words) {
            for(char c: word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int index = 0;
            boolean isDiff = false;
            while(index < Math.min(word1.length(), word2.length())) {
                if(word1.charAt(index) != word2.charAt(index)) {
                    graph.get(word1.charAt(index)).add(word2.charAt(index));
                    isDiff = true;
                    break;
                } else {
                    index++;
                    isDiff = false;
                }    
            }
            if(word1.length() > word2.length() && !isDiff) {
                return "";
            }
        }

        for(Character c: graph.keySet()) {
            if(f(graph, c, visited)) return "";
        }
        
        return sb.reverse().toString();
    }

    boolean f(Map<Character, Set<Character>> graph, Character c, Map<Character, Integer> visited) {
        if(visited.getOrDefault(c,0) == 1) return true;
        if(visited.getOrDefault(c,0) == 2) return false;
        visited.put(c, 1);
        for(Character next: graph.get(c)) {
            if(f(graph, next, visited)) return true;
        }
        sb.append(c);
        visited.put(c,2);
        return false;
    }
}








