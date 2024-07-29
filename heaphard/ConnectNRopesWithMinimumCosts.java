package heaphard;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCosts {
	long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int length = arr.length;
        for(int i=0;i<length;i++)
        {
            pq.add(arr[i]);
        }
        long cost=0;
        while(pq.size()>1)
        {
            long first = pq.poll();
            long second = pq.poll();
            cost=cost+first+second;
            pq.add(first+second);
        }
        return cost;
    }
}
