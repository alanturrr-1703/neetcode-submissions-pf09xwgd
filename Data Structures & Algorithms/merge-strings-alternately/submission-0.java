class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        while(i < len1 && i < len2){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if(len1 > len2) sb.append(word1.substring(i, len1));
        if(len1 < len2) sb.append(word2.substring(i, len2));
        return sb.toString();
    }
}