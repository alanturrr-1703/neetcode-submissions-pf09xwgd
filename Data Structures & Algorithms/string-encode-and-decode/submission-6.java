class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.append(str.length());
            res.append('#');
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int l = 0;
        while(l < str.length()){
            int r = l;
            while(str.charAt(r) != '#') r++;
            int len = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            r = l + len;
            res.add(str.substring(l, r));
            l = r;
        }
        return res;
    }
}
