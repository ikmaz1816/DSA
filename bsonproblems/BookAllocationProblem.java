package bsonproblems;

import java.util.ArrayList;

public class BookAllocationProblem {
	public static int findPages(ArrayList<Integer> arr, int n, int k) {
        if(k>n)
            return -1;
        int start=0;
        int end = 0;
        for(int i:arr)
        {
            end+=i;
            start=Math.max(start,i);
        }

        while(start<=end)
        {
            int mid = (start+end)/2;
            int sumTillMid = sumTillMid(arr,mid);
            if(sumTillMid>k)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }
    public static int sumTillMid(ArrayList<Integer> arr,int mid)
    {
        int count=1,sum=0;
        for(int i:arr)
        {
            if(sum+i>mid)
            {
                sum=i;
                count++;
            }
            else
                sum+=i;
        }
        return count;
    }
}
