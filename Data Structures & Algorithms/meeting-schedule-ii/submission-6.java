/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
 // 0 40,  5 10,   15 20

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval itv: intervals) {
            if(!pq.isEmpty() && pq.peek() <= itv.start) {
                pq.poll();
            }
            pq.add(itv.end);
        }
        return pq.size();
        

    }
}
