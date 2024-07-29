package heapsmedium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
	public static int kthSmallest(int[] nums, int l, int r, int k) 
    { 
        int length = nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++)
            pq.add(nums[i]);
        for(int i=k;i<length;i++)
        {
            if(pq.peek()>=nums[i])
            {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    } 
}
