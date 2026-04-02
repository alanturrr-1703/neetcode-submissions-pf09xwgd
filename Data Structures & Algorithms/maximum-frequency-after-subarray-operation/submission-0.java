class Solution {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums){
            int prev = Math.max(map.getOrDefault(num, 0), map.getOrDefault(k, 0));
            map.put(num, prev + 1);
            res = Math.max(res, map.get(num) - map.getOrDefault(k, 0));
        }
        return map.getOrDefault(k, 0) + res;
    }
}