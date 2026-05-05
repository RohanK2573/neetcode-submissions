class Pair{
    double time;
    int position;
    Pair(double time,int position){
        this.time=time;
        this.position=position;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] arr=new Pair[position.length];
        for(int i=0;i<position.length;i++){
            arr[i]=new Pair((double)(target-position[i])/speed[i],position[i]);
    
        }
        Arrays.sort(arr,(a,b)-> a.position-b.position);
        int j=arr.length-2;
        int fleet=1;
        double timecompare=arr[arr.length-1].time;
        while(j>=0){
            if(arr[j].time>timecompare){ 
                fleet++;
                    timecompare = arr[j].time;
                 
            }
            j--;

        }
        return fleet;

      
        
    }
}
