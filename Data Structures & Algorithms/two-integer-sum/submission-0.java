class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            indices.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++){
            int diff = target - nums[j];
            if(indices.containsKey(diff) && indices.get(diff) != j){
                return new int[] {j, indices.get(diff)};
            }
        }
        return new int[0];
    }
}
