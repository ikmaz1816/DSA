package bsonproblems;

import java.util.Arrays;

public class AggressiveCows {
	 public static int solve(int n, int k, int[] stalls) {
	        Arrays.sort(stalls);
	        int start = 1;
	        int end = stalls[n-1];
	        while(start<=end)
	        {
	            int mid = (start+end)/2;
	            int countOfCowsPlaced = getCountOfCowsPlaced(stalls,n,mid);
	            if(countOfCowsPlaced>=k)
	                start=mid+1;
	            else
	                end=mid-1;
	        }
	        return start;
	    }
	    public static int getCountOfCowsPlaced(int[] stalls,int length,int mid)
	    {
	        int count=1;
	        int initialValue = stalls[0];
	        for(int i=1;i<length;i++)
	        {
	            if(stalls[i]-initialValue>mid)
	            {
	                count++;
	                initialValue = stalls[i];
	            }
	        }
	        return count;
	    }
}
