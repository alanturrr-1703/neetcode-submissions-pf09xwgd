class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s.length());
            res.append("#");
            res.append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int l = 0;
        List<String> res = new ArrayList<>();
        while(l < str.length()){
            int r = l;
            while(str.charAt(r) != '#') r++;
            int len = Integer.parseInt(str.substring(l,r));
            l = r + 1;
            r = l + len;
            res.add(str.substring(l, r));
            l = r;
        }
        return res;
    }
}
