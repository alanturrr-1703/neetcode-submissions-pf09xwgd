class Solution {
    public int uniquePaths(int m, int n) {
        int[] t = new int[n];
        Arrays.fill(t, 1);
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--) t[j] += t[j + 1];
        }
        return t[0];
    }
}
