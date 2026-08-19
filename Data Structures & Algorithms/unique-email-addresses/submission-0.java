class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>(); 
        for(String email: emails) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if(c == '.') {
                    continue;
                } else if(c == '+') {
                    while (email.charAt(i) != '@') i++;
                    sb.append(email.substring(i, email.length()));
                    break;
                } else if(c == '@') {
                    sb.append(email.substring(i, email.length()));
                    break;
                } else {
                    sb.append(c);
                }
            }
            if(sb.length() != 0) set.add(sb.toString());
        }
        return set.size();
    }
}