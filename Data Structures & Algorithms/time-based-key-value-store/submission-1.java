class Data {
    String value;
    int time;
    Data(String value, int time){
        this.value = value;
        this.time = time;
    }
}
class TimeMap {
    HashMap<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        String res = "";
        List<Data> searchList = map.get(key);
        int l = 0;
        int r = searchList.size() - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(searchList.get(m).time == timestamp) return searchList.get(m).value;
            else if(searchList.get(m).time < timestamp){
                res = searchList.get(m).value;
                l = m + 1;
            } else r = m -1;
        }
        return res;
    }
}
