class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        int lMax = height[l], rMax = height[r];
        while(l < r){
            if(lMax < rMax){
                l++;
                lMax = Math.max(lMax, height[l]);
                maxArea += lMax - height[l];
            } else{
                r--;
                rMax = Math.max(rMax, height[r]);
                maxArea += rMax - height[r];
            }
        }
        return maxArea;
    }
}
