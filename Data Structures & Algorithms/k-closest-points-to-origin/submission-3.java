class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {

       PriorityQueue<Pair> pq = new PriorityQueue<>(

    (a, b) -> Double.compare(distance(b.x, b.y), distance(a.x, a.y))

);
        for(int i=0;i<points.length;i++){
            if(pq.size()<k){
                pq.offer(new Pair(points[i][0],points[i][1]));
            }else{
                Pair top=pq.peek();
                if(distance(points[i][0],points[i][1])<distance(top.x,top.y)){
                    pq.poll();
                    pq.offer(new Pair(points[i][0],points[i][1]));
                }
            }
        }
        int[][] ans=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            ans[i][0]=curr.x;
            ans[i][1]=curr.y;
            i++;
        }
        return ans;




        

    }

    public double distance(int x,int y){
            return Math.sqrt(x * x + y * y);
    }
}
