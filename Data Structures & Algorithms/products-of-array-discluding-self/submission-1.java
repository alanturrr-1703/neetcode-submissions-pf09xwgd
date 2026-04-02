class Solution {
    // for example we have this [1, 2, 4, 6]
    // first we multiply prefixes like [1, 1, 2, 8]
    // declare a postfix = 1 then multiply using that postfix
    // [48, 24, 12, 8]
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}  
