class Pair{
    double d;
    int[] point;
    Pair(double d,int[] point){
        this.d=d;
        this.point=point;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
              PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.d, a.d));
        for(int i=0;i<points.length;i++){
            if(pq.size()<k){
                pq.offer(new Pair(findDistance(points[i]),points[i]));
            }else{
                double td=findDistance(points[i]);
                if(td<pq.peek().d){
                    pq.remove();
                    pq.offer(new Pair(td,points[i]));
                }
            }
        }
        int[][] ans=new int[k][2];
        int id=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            ans[id++]=p.point;
        }
        return ans;


        

    }

    public double findDistance(int[] points){
      return Math.sqrt(

    Math.pow(points[0], 2) + Math.pow(points[1], 2)

);
    }
}
