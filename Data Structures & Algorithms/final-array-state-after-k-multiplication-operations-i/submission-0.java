class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        for(int i = 0; i < nums.length; i++) pq.offer(new int[] {nums[i], i});
        for(int i = 0; i < k; i++){
            int[] n = pq.poll();
            pq.offer(new int[] {n[0] * multiplier, n[1]});
        }
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            nums[p[1]] = p[0];
        }
        return nums;
    }
}