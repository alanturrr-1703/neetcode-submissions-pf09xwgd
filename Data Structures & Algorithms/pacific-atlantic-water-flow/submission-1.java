class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int rows, cols;
    Queue<int[]> pq = new LinkedList<>();
    Queue<int[]> aq = new LinkedList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            pq.offer(new int[] {r, 0});
            aq.offer(new int[] {r, cols - 1});
            pacific[r][0] = true;
            atlantic[r][cols - 1] = true;
        }
        for(int c = 0; c < cols; c++){ 
            pq.offer(new int[] {0, c});
            aq.offer(new int[] {rows - 1, c});
            pacific[0][c] = true;
            atlantic[rows - 1][c] = true;
        }
        bfs(heights, pq, pacific);
        bfs(heights, aq, atlantic);

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pacific[r][c] && atlantic[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }
    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            int[][] directions = new int[][] {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
            for(int[] dir : directions){
                int nr = r + dir[0], nc = c + dir[1];
                
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && heights[nr][nc] >= heights[r][c] && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
