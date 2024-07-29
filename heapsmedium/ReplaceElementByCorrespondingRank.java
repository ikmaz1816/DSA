package heapsmedium;

import java.util.PriorityQueue;

class Replace
{
    int data;
    int index;
    public Replace(int data,int index)
    {
        this.data=data;
        this.index=index;
    }
}
public class ReplaceElementByCorrespondingRank {
	static int[] replaceWithRank(int arr[], int N) {
	     int[] ans = new int[N];
	     PriorityQueue<Replace> pq=new PriorityQueue<>((x,y)->x.data-y.data);
	     for(int i=0;i<N;i++)
	     {
	         pq.add(new Replace(arr[i],i));
	     }
	     int count=0;
	     int element=0;
	     while(!pq.isEmpty())
	     {
	         Replace replace = pq.poll();
	         if(element==replace.data)
	         {
	            ans[replace.index]=count;
	         }
	         else
	         {
	            ans[replace.index]=++count;
	         }
	         element=replace.data;
	     }
	     return ans;
	  }
}
