package bsonproblems;

public class KthMissingPositiveNumberOptimized {
	public int findKthPositive(int[] arr, int k) {
		/*the array is sorted meaning that the problem can be solved using bs
	       now we wll be using the index as a part of our solution
	       at index zero the value should be 1
	       so to count the missing number it is equal to arr[i] -index
	       if(missing < k)
	            start = mid+1;
	        else 
	            end = mid-1;

	            After this start and end would point to numbers where the missing would lie between
	            So start = 11 and end = 7

	       */
	       int start=0;
	       int end=arr.length-1;
	       while(start<=end)
	       {
	            int mid = (start+end)/2;
	            int missing = arr[mid] - (mid+1);
	            if(missing<k)
	                start=mid+1;
	            else
	                end=mid-1;
	       }
	       /*   
	            out actual answer is 
	            arr[end] + missing
	            missing = k - (arr[end]-(end+1))  // 5 - (7-(4)) = 5-3 = 2
	            arr[end] + k - arr[end] + end +1
	            end+k+1
	       */
	       return end+1+k;
    }
}
