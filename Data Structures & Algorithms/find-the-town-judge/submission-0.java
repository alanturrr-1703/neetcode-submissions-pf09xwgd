class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        for(int[] t : trust){
            indegree[t[1]]++;
            outdegree[t[0]]++;
        }
        for(int i = 0; i < n + 1; i++){
            if(indegree[i] == n - 1 && outdegree[i] == 0) return i;
        }
        return -1;
    }
}