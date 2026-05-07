class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int[] visited=new int[n];
        Arrays.fill(visited,0);
   

        if (detectCycle(0, -1, visited, adjList)) return false;

        for (int i = 0; i < n; i++) {

            if (visited[i] == 0) return false;

        }

        return true;





    }

    public boolean detectCycle(int start,int parent,int[] visited,List<List<Integer>>adjList){
        visited[start]=1;
        for(int i=0;i<adjList.get(start).size();i++){
            int node=adjList.get(start).get(i);
            if(visited[node]==0){
                if(detectCycle(node,start,visited,adjList)) return true;
            }else{
                if(node!=parent) return true;
            }
        }
        return false;
    }
}
