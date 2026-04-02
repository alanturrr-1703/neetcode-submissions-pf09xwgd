class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.offer(beginWord);
        int length = 0;
        while(!q.isEmpty()){
            int size = q.size();
            length++;
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                for(int j = 0; j < curr.length(); j++){
                    char[] charArray = curr.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        charArray[j] = c;
                        String newWord = new String(charArray);
                        if(endWord.equals(newWord)) return length + 1;
                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
