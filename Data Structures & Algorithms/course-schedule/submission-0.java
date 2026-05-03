class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new ArrayDeque<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
             adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int[] edges=prerequisites[i];
            adj.get(edges[1]).add(edges[0]);
            indegree[edges[0]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int ele=q.poll();
            List<Integer> nodes=adj.get(ele);
            for(int i=0;i<nodes.size();i++){
                indegree[nodes.get(i)]--;
                if(indegree[nodes.get(i)]==0) q.offer(nodes.get(i));
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]!=0) return  false;
        }
        return true;



        
        
    }
}
