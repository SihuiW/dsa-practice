class StringIterator {
    String s;
    int idx = 0;

    char cur = ' ';
    int count = 0;

    public StringIterator(String compressedString) {
        this.s = compressedString;
    }

    public char next() {
        if (!hasNext()) return ' ';

        if (count == 0) {
            cur = s.charAt(idx++);
            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                count = count * 10 + (s.charAt(idx) - '0');
                idx++;
            }
        }

        count--;
        return cur;
    }

    public boolean hasNext() {
        return count > 0 || idx < s.length();
    }
}