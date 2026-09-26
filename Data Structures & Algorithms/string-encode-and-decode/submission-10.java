class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.append(str.length());
            res.append("#");
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int l = 0;
        int r = 0;
        List<String> res = new ArrayList<>();
        while(r < str.length()){
            while(str.charAt(r) != '#') r++;
            int length = Integer.parseInt(str.substring(l, r));
            res.add(str.substring(r + 1, r + length + 1));
            r = r + length + 1;
            l = r;
        }
        return res;
    }
}
