class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            int count = 0;
            int dummy = i;
            while(dummy > 0){
                if((dummy & 1) == 1) count++;
                dummy = dummy >> 1;
            }
            res[i] = count;
        }
        return res;
    }
}
