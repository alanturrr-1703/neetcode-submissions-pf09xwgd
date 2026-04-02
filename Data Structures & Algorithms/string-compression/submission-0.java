class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int index = 0;
        while(l < chars.length){
            int r = l;
            while(r < chars.length && chars[l] == chars[r]) r++;
            chars[index++] = chars[l];
            if(r - l > 1){
                String count = r - l + "";
                for(char c : count.toCharArray()) chars[index++] = c;
            }
            l = r;
        }
        return index;
    }
}