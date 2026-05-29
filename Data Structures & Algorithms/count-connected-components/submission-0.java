class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int count=0;
        int [] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,adjList,visited);
                count++;
            }
        }
        return count;


    }

    public void dfs(int src,List<List<Integer>> adjList,int[] visited){
        visited[src]=1;
        List<Integer> nodes=adjList.get(src);
        for(Integer node: nodes){
            if(visited[node]==0){
                dfs(node,adjList,visited);
            }
        }

    }
}
