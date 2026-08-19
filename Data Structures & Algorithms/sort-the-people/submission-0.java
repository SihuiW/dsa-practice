class Solution {
    class People {
        String name;
        int height;
        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<People> pq = new PriorityQueue<>((a,b) -> b.height - a.height);
        for(int i = 0; i < names.length; i++) {
            pq.add(new People(names[i], heights[i]));
        }
        String[] sb = new String[names.length];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = pq.poll().name;
        }
        return sb;
    }
}