package heapsmedium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair
{
    int data;
    int rowindex;
    int colindex;
    public Pair(int data,int rowindex,int colindex)
    {
        this.data=data;
        this.rowindex=rowindex;
        this.colindex=colindex;
    }
}
public class SortKSortedArrays {
	public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<>()
        {
            public int compare(Pair x,Pair y)
            {
                return x.data-y.data;
            }
        });
        for(int i=0;i<K;i++)
        {
            pq.add(new Pair(arr[i][0],i,0));
        }
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            ans.add(p.data);
            if(p.colindex<K-1)
            {
                pq.add(new Pair(arr[p.rowindex][p.colindex+1],p.rowindex,p.colindex+1));
            }
        }
        return ans;
        
    }
}
