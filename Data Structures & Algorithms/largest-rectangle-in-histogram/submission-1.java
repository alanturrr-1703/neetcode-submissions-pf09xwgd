class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int left = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] curr = stack.pop();
                maxArea = Math.max(maxArea, (i - curr[0]) * curr[1]);
                left = curr[0];
            }
            stack.push(new int[] {left, heights[i]});
        }
        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            maxArea = Math.max(maxArea, (n - curr[0]) * curr[1]);
        }
        return maxArea;
    }
}
