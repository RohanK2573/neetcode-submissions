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

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<intervals.size();i++){
            map.put(intervals.get(i).start,map.getOrDefault(intervals.get(i).start,0)+1);
  map.put(intervals.get(i).end,map.getOrDefault(intervals.get(i).end,0)-1);
            
        }
        int overlap=0;
        int maxOverlap=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            overlap+=entry.getValue();
            if(overlap>maxOverlap) maxOverlap=overlap;
        }
        return maxOverlap;
      



    }
}
