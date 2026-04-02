class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        for(int vertex = 0; vertex < n; vertex++){
            adj.put(vertex, new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        if(!bfs(0)) return false;
        return visited.size() == n;
    }
    public boolean bfs(int vertex){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {vertex, -1});
        visited.add(vertex);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int child : adj.get(node)){
                if(!visited.contains(child)){
                    q.offer(new int[] {child, node});
                    visited.add(child);
                } else if(child != parent) return false;
            }
        }
        return true;
    }
}
