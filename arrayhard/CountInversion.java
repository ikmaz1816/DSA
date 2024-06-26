package arrayhard;

import java.util.ArrayList;

public class CountInversion {
	 public static long merge(long[] arr,int start,int mid,int end)
	    {
	        ArrayList<Long> tempStorage=new ArrayList<>();
	        int i=start;
	        int j=mid+1;
	        long count = 0;
	        while(i<=mid && j<=end)
	        {
	            if(arr[i]<=arr[j])
	            {
	                tempStorage.add(arr[i]);
	                i++;
	            }
	            else
	            {
	               
	                 count+=mid-i+1;
	                tempStorage.add(arr[j]);
	                j++;
	            }
	        }
	        while(i<=mid)
	        {
	            tempStorage.add(arr[i]);
	            i++;
	        }
	        while(j<=end)
	        {
	            tempStorage.add(arr[j]);
	            j++;
	        }
	        for(int u=0;u<tempStorage.size();u++)
	        {
	            arr[u+start] = tempStorage.get(u);
	        }
	        return count;
	        
	    }
	    public static long mergesort(long[] arr,int start,int end)
	    {
	        long cnt=0;
	        if(start>=end)
	            return 0;
	        int mid = (start+end)/2;
	        cnt = mergesort(arr,start,mid);
	        cnt+=mergesort(arr,mid+1,end);
	        cnt+=merge(arr,start,mid,end);
	        return cnt;
	    }
	    static long inversionCount(long arr[], int n) {
	        return mergesort(arr,0,arr.length-1);
	    }
}
