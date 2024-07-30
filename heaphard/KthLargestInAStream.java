package heaphard;

import java.util.PriorityQueue;

public class KthLargestInAStream {
	PriorityQueue<Integer> pq;
    int remainingK=0;
    public KthLargestInAStream(int k, int[] nums) {
        pq=new PriorityQueue<>();
        int length = nums.length;
        for(int i=0;i<length;i++)
        {
            if(k>0)
            {
                pq.add(nums[i]);
                k--;
            }
            else
            {
                if(pq.peek()<nums[i])
                {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        remainingK=k;
    }
    
    public int add(int val) {
        if(pq.isEmpty() || remainingK>0)
        {
            pq.add(val);
            remainingK--;
        }
        else if(pq.peek()<val)
        {
            pq.poll();
            pq.add(val);
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }
}
