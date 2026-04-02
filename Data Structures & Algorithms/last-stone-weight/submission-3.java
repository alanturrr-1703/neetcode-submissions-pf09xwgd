class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int stone : stones) heap.offer(stone);
        while(heap.size() > 1){
            int first = heap.poll();
            int second = heap.poll();
            heap.offer(first - second);
        }
        return heap.size() == 0 ? 0 : heap.poll();
    }
}
