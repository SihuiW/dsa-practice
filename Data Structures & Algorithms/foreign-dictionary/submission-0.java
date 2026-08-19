class Solution {
    
    StringBuilder sb = new StringBuilder();

    public String foreignDictionary(String[] words) {
        // 1. 建图
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>(); // 后面DFS会用到的状态
        // 1.1 初始化：把所有字母加入图中
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        
        // 1.2 比较相邻单词，建立边
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // TODO: 你来实现这部分
            // 比较 word1 和 word2
            boolean isDiff = false;
            int index = 0;
            while(index < Math.min(word1.length(), word2.length())) {
                // 找到第一个不同的字母，添加边
                char a = word1.charAt(index), b = word2.charAt(index);
                if(a != b) {
                    graph.get(a).add(b);
                    isDiff = true;
                    break;
                } else {
                    isDiff = false;
                    index++;
                }
            }
            // 注意检查无效情况
            if(word1.length() > word2.length() && !isDiff) return "";
            
        }

        for(Character c: graph.keySet()) {
            if(f(graph, inDegree, c)) return "";
        }

        return sb.reverse().toString();

    }

    // 2. DFS 拓扑排序
        // ...
        boolean f(Map<Character, Set<Character>> graph, Map<Character, Integer> inDegree, Character c) {
            if(inDegree.getOrDefault(c, 0) == 1) return true;
            if(inDegree.getOrDefault(c, 0) == 2) return false;
            inDegree.put(c, 1);
            for(Character next: graph.get(c)) {
                if(f(graph,inDegree,next)) return true;
            }
            sb.append(c);
            inDegree.put(c,2);
            return false;
        }

}