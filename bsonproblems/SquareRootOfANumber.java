package bsonproblems;

public class SquareRootOfANumber {
	long floorSqrt(long x)
	 {
	    if(x==0 || x==1)
	        return x;
		long start = 1;
		long end = x/2;
		long ans = -1;
		while(start<=end)
		{
		    long mid = (start+end)/2;
		    if(mid<=x/mid)  // mid * mid ==x this can also be taken but there are chances that
		    	// mid * mid can be a very big value and also less than case is handled
		    {
		        ans=mid;
		        start = mid+1;
		    }
		    else
		        end=mid-1;
		}
		return ans;
	 }
}
