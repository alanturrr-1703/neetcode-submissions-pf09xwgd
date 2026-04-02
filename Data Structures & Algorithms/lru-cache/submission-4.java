class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;
    private Deque<Integer> deque;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            deque.remove(key);
            deque.addFirst(key);
        } else{
            if(deque.size() == capacity){
                int lru = deque.removeLast();
                map.remove(lru);
            }
            deque.addFirst(key);
            map.put(key, value);
        }
    }
}
