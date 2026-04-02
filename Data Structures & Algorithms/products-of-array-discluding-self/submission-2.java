class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we need to solve it in O(N) without division operations
        // we can make an output array for this
        int[] output = new int[nums.length];
        output[0] = 1;
        // output[i] = output[i - 1] * nums[i - 1];
        for(int i = 1; i < nums.length; i++){
            output[i] = nums[i - 1] * output[i - 1];
        }
        // this would make[1, 2, 4, 6] -> [1, 1, 2, 8]

        // then we can define another postfix variable
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            output[i] *= postfix;
            postfix *= nums[i];
        }
        // this makes the array [1, 1, 2, 8] -> [48, 24, 12, 8]
        return output;

    }
}  
