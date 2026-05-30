class Solution {
    private boolean allVisited(int[] visited, int n) {

    for (int i = 1; i < n; i++) {

        if (visited[i] == 0) return false;

    }

    return true;

}
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList= new ArrayList<>();
        int n=edges.length+1;
        int[] ans=new int[2];
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        for(int j=edges.length-1;j>=0;j--){
            int[] visited =new int[n];
            int parent=-1;
         adjList.get(edges[j][0]).remove(Integer.valueOf(edges[j][1]));
adjList.get(edges[j][1]).remove(Integer.valueOf(edges[j][0]));
            if(!detectCycle(visited,1,-1,adjList) && allVisited(visited, n)){
                return edges[j];
            }
                adjList.get(edges[j][0]).add(edges[j][1]);
            adjList.get(edges[j][1]).add(edges[j][0]);
        }
        return ans;

    }

    public boolean detectCycle(int[] visited,int src,int parent,List<List<Integer>> adjList){
        visited[src]=1;
        List<Integer> nodes=adjList.get(src);
        for(Integer node: nodes){
            if(visited[node]==1){
                if(node!=parent) return true;
            }else{
                if (detectCycle(visited, node, src, adjList)) {

                return true;

            }
            }
        }
        return false;
    }
}