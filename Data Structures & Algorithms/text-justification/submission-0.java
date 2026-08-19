public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        
        List<String> line = new ArrayList<>();
        
        int length = 0;
        
        int i = 0;
        
        while (i < words.length) {
            
            // 判断当前单词是否能加入这一行
            // length：已有单词字符数
            // words[i].length()：新单词长度
            // line.size()：当前已有单词个数 → 需要加的“最少空格数”（每个单词间至少1个空格）
            if (length + words[i].length() + line.size() <= maxWidth) {
                
                // 可以加入：把单词加到当前行
                line.add(words[i]);
                
                // 更新当前行的“纯字符长度”
                length += words[i].length();
                
                // 指针后移，处理下一个单词
                i++;
            } 
            
            // 放不下 → 当前行已满，需要排版并加入结果
            else {
                
                // 计算这一行总共还剩多少空格要分配
                int extra_space = maxWidth - length;
                
                // 如果这一行只有一个单词，则 gaps = 0（避免除0）
                // 否则 gaps = 单词间隙数 = 单词数 - 1
                int gaps = Math.max(1, line.size() - 1);
                
                // 每个间隙“至少”要分配的空格数
                int space = extra_space / gaps;
                
                // 余数：还需要额外均匀分配的空格个数（从左往右多给一个）
                int remainder = extra_space % gaps;
                
                // 开始在单词之间插入空格（注意：最后一个单词后面不加空格）
                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    
                    // 先给每个间隙加上“基础空格数”
                    line.set(j, line.get(j) + " ".repeat(space));
                    
                    // 如果还有余数，从左往右每个间隙再多加一个空格
                    if (remainder > 0) {
                        line.set(j, line.get(j) + " ");
                        remainder--;
                    }
                }
                
                // 把当前行所有单词（已带空格）拼接成一个字符串，加入结果
                res.add(String.join("", line));
                
                // 清空当前行，准备下一行
                line.clear();
                length = 0;
            }
        }
        
        // 处理最后一行（特殊情况：左对齐，单词之间只用一个空格，右边补空格到 maxWidth）
        String last_line = String.join(" ", line);
        
        // 计算最后一行右边需要补多少空格
        int trail_space = maxWidth - last_line.length();
        
        // 补上右边的空格（最后一行不做两端对齐）
        res.add(last_line + " ".repeat(trail_space));
        
        // 返回所有处理好的行
        return res;
    }
}