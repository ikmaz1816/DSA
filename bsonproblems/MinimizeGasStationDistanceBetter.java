package bsonproblems;

import java.util.PriorityQueue;

class Pair
{
    double data;
    int index;
    public Pair(double data,int index)
    {
        this.data=data;
        this.index=index;
    }
}
public class MinimizeGasStationDistanceBetter {
	
	public static double findSmallestMaxDist(int arr[], int k) {
        
        int length = arr.length;
        int[] stepsTaken =  new int[length-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.data, a.data));
        for(int i=0;i<length-1;i++)
        {
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }
        
        for(int i=0;i<k;i++)
        {
            Pair p = pq.poll();
            int index = p.index;
            stepsTaken[index]++;
            double diff = (double)(arr[index+1]-arr[index]);
            double potentialAnswer = diff/(double)(stepsTaken[index]+1);
            
            pq.add(new Pair(potentialAnswer,index));
        }
        return pq.peek().data;
    }
}
