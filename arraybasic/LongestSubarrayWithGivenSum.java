package arraybasic;

import java.util.HashMap;

public class LongestSubarrayWithGivenSum {
	 public static int lenOfLongSubarr (int A[], int N, int K) {
	        HashMap<Integer,Integer> map=new HashMap<>();
	        int sum=0;
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<N;i++)
	        {
	        	sum+=A[i];
	        	if(sum==K)
	        	{
	        		max=i+1;
	        	}
	        	if(map.containsKey(sum)==false)
	        	{
	        		map.put(sum, i);
	        	}
	        	if(map.containsKey(sum-K))
	        	{
	        		max = Math.max(max,i-map.get(sum-K));
	        	}
	        }
	        return max;
	    }
}
