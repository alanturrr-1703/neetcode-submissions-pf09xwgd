class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        largeHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);
        if(!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) largeHeap.offer(smallHeap.poll());
        
        if(smallHeap.size() - largeHeap.size() > 1) largeHeap.offer(smallHeap.poll());
        if(largeHeap.size() - smallHeap.size() > 1) smallHeap.offer(largeHeap.poll());
    }
    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()) return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        if(smallHeap.size() > largeHeap.size()) return (double) smallHeap.peek();
        else return largeHeap.peek();
    }
}
