package heapsmedium;

import java.util.PriorityQueue;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        //for finding largest we implement min heap and for finding smallest we implement max heap
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
            pq.add(nums[i]);
        for(int i=k;i<length;i++)
        {
            if(pq.peek()<=nums[i])
            {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
