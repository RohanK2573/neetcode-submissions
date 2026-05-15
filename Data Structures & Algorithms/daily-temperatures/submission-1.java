class Pair{
    int temp;
    int idx;
    Pair(int temp,int idx){
        this.temp=temp;
        this.idx=idx;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s=new Stack<>();
        int j=temperatures.length-1;
        int[] ans=new int[temperatures.length];
        while(j>=0){
            int c=0;
            while(!s.isEmpty() && s.peek().temp<=temperatures[j]){
                s.pop();
                c++;
            }
            if(s.isEmpty()) {
                ans[j]=0;
                }
            else{
                ans[j]=s.peek().idx-j;
            }
        
            s.add(new Pair(temperatures[j],j));
            j--;
        }
        return ans;
        
        
    }
}
