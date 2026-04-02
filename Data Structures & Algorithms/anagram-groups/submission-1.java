class Solution {
    // anagram should have same characters with same freq
    // map every anagram togather
    // sort an anagram act
    // ababc babca -> aabbc
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
