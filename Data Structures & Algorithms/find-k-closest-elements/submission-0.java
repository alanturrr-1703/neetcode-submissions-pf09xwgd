class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]
        );
        for(int num : arr){
            int e = Math.abs(num - x);
            maxHeap.offer(new int[] {e, num});
            if(maxHeap.size() > k) maxHeap.poll();
        }
        List<Integer> res = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll()[1]);
        }
        Collections.sort(res);
        return res;
    }
}