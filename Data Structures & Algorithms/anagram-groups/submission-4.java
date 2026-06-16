class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char [] str = s.toCharArray();
            Arrays.sort(str);
            String sortedString = new String(str);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
