package heaphard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInARunningStream {
	PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;
    public MedianInARunningStream() {
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        minQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxQueue.isEmpty() || maxQueue.peek()>=num)
            maxQueue.add(num);
        else
            minQueue.add(num);
        
        if(maxQueue.size()>minQueue.size()+1)
            minQueue.add(maxQueue.poll());
        else if(minQueue.size()>maxQueue.size())
            maxQueue.add(minQueue.poll());
    }
    
    public double findMedian() {
        if(maxQueue.size()==minQueue.size())
        {
            return (maxQueue.peek()+minQueue.peek())/2.0;
        }
        return maxQueue.peek();
    }
}
