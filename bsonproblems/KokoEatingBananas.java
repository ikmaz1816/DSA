package bsonproblems;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
	       /*The first approach while solving this problem is to understand that the array is sorted
	        We will be using binary search to solve this problem 
	        Now let us define the search space
	        Koko can eat minimum of min(piles) and maximum of max(piles)
	        count = piles[]/appropriate number
	        3,6,7,11 
	        3/4+6/4+7/4+11/4 = 5 which is less than the hours provided
	        Now start has to be one because if there one a single element with value 325679 and h=325678
	        then in this case we need to have a search space from 1 to 325679
	        */
	        int end=-1,start=1;
	        for(int i:piles)
	        {
	            end = Math.max(end,i);
	        }
	        while(start<=end)
	        {
	            int mid =(start+end)/2;
	            int hoursRequiredWithGivenMid = countHours(piles,mid,h);
	            if(hoursRequiredWithGivenMid<=h)
	            {
	                end=mid-1;
	            }
	            else
	            {
	                start=mid+1;
	            }
	        }
	        return start;
	    }

	    public int countHours(int[] piles,int mid,int h)
	    {
	        int count=0;
	        for(int i:piles)
	        {
	            count+=Math.ceil((i*1.0)/mid);
	        }
	        return count;
	    }
}
