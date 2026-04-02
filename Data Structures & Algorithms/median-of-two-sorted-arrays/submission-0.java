class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] nums3 = new int[m + n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            nums3[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            nums3[k] = nums2[j];
            j++;
            k++;
        }
        int mid = (m + n)/2;
        boolean isEven = (m + n) % 2 == 0;
        return isEven ? (nums3[mid - 1] + nums3[mid]) / 2.0 : nums3[mid];
    }
}
