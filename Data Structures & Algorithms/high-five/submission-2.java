class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int[] item : items){
            map.putIfAbsent(item[0], new PriorityQueue<>((a, b) -> Integer.compare(b, a)));
            map.get(item[0]).offer(item[1]);
        }
        int[][] res = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int studentId = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            int sum = 0;
            for(int i = 0; i < 5; i++) sum += pq.poll();
            res[idx][0] = studentId;
            res[idx][1] = sum/5;
            idx++;
        }
        return res;
    }
}
