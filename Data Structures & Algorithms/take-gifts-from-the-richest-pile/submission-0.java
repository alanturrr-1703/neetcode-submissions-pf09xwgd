class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int gift : gifts) pq.offer(gift);
        for(int i = 0; i < k; i++){
            int n = pq.poll();
            pq.offer((int) Math.floor(Math.sqrt(n)));
        }
        long sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}