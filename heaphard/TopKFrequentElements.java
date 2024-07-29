package heaphard;

import java.util.HashMap;
import java.util.PriorityQueue;

class Frequent
{
    int data;
    int count;
    public Frequent(int data,int count)
    {
        this.data=data;
        this.count=count;
    }
}
public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Frequent> pq=new PriorityQueue<>((a,b)->b.count-a.count);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int i:map.keySet())
            pq.add(new Frequent(i,map.get(i)));
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty() && k>0)
        {
            ans[i++]=pq.poll().data;
            k--;
        }
        return ans;
    }
}
