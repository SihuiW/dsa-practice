class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stk = new Stack<>();
        for(String p: paths) {
            if(p.isEmpty() || p.equals(".")) continue;
            if (p.equals("..")) {
                if(!stk.isEmpty()) stk.pop();
            } else {
                stk.push(p);
            }
        }
        if(stk.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(String s: stk) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}