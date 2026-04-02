class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long start = 1;
        long end = getMaximum(piles);
        while(start<=end){
            long mid = start + (end - start)/2;
            long totalHours = findTotalHours(piles,mid);
            if(totalHours<=h){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)start;
    }
    public long getMaximum(int[] piles){
        long max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
    public long findTotalHours(int[] piles, long hourly){
        long totalhours = 0;
        for(int pile : piles){
            totalhours += (pile + hourly - 1) / hourly;
        }
        return totalhours;
    }
}