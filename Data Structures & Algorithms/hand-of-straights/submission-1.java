class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<hand.length;i++){map.put(hand[i],map.getOrDefault(hand[i],0)+1);}
        Arrays.sort(hand);
        
        for(int i=0;i<hand.length;i++){
            int c=0;
            if(map.containsKey(hand[i])){
                int start=hand[i];
                while(c<groupSize){
                    if(map.containsKey(start)){
                        map.put(start,map.get(start)-1);
                        if(map.get(start)==0) map.remove(start);
                        start++;
                        c++;
                    }else{
                        return false;
                    }

                }

            }
        }
        return true;
        
    }
}
