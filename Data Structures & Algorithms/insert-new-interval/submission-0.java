class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][] {newInterval};
        int n = intervals.length;
        int target = newInterval[0];
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(intervals[mid][0] < target) left = mid + 1;
            else right = mid - 1;
        }
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (i == left) result.add(newInterval);
            result.add(intervals[i]);
        }
        if (left == n) result.add(newInterval);

        List<int[]> merged = new ArrayList<>();
        for(int[] interval : result){
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) merged.add(interval);
            else merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
        }
        return merged.toArray(new int[0][]);
    }
}