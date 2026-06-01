class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] rank=new int[n+1];
        int[] parent=new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }

        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            int u=edge[0];
            int v=edge[1];
            int pu=findPar(parent,u);
            int pv=findPar(parent,v);
            if(pu==pv) return edge;
            if(rank[pu]==rank[pv]){
                rank[pu]++;
                parent[pv]=pu;
            }else{
                int child=0;
                int par=0;
                if(rank[pu]<rank[pv]){
                     child=pu;
                     par=pv;
                }else{
                    child=pv;
                    par=pu;
                }
                parent[child]=par;
            }
        }
        return new int[]{};


        
    }

    public int findPar(int[] parent,int u){
        if(parent[u]==u) return u;
        return parent[u]=findPar(parent,parent[u]);
    }




}
