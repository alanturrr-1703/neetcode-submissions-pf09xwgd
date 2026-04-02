class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int area = 0;
        int maxArea = 0;
        while(l < r){
            area = Math.min(heights[l], heights[r]) * (r - l);
            if(heights[l] < heights[r]) l++;
            else r--;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
