package arrayhard;

import java.util.ArrayList;

public class ReversePairs {
	public void merge(int[] arr,int start,int mid,int end)
    {
        ArrayList<Integer> tempStorage=new ArrayList<>();
        int i=start;
        int j=mid+1;
        while(i<=mid && j<=end)
        {
            if(arr[i]<=arr[j])
            {
                tempStorage.add(arr[i]);
                i++;
            }
            else
            {
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
        
    }
    public int reversePair(int[] arr,int start,int mid,int end)
    {
        int count = 0;
        int right = mid+1;
        for(int i=start;i<=mid;i++)
        {
            while(right <= end && (arr[i] >2 * (long)arr[right])) 
            {
                right++;
              }
            count += (right-(mid+1));
        }
        return count;
    }
    public int mergesort(int[] arr,int start,int end)
    {
        int cnt=0;
        if(start>=end)
            return cnt;
        int mid = (start+end)/2;
        cnt+= mergesort(arr,start,mid);
        cnt+=mergesort(arr,mid+1,end);
        cnt+=reversePair(arr,start,mid,end);
        merge(arr,start,mid,end);
        return cnt;
    }
public int reversePairs(int[] nums) {
    return mergesort(nums,0,nums.length-1);
}
}
