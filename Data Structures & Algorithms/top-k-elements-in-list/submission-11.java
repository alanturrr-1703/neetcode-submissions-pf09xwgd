class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums){
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        List<Integer> [] arrayOfList = new ArrayList[nums.length + 1];
        for(int i = 0; i < arrayOfList.length; i++){
            arrayOfList[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()){
            arrayOfList[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = arrayOfList.length - 1; i > 0; i--){
            for(int n : arrayOfList[i]){
                res[index++] = n;
                if(index == k) return res;
            }
        }
        return res;
    }
}
