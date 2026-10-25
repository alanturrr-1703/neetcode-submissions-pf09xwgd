class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sorted string : List<string>
        // List<List<String>>
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
