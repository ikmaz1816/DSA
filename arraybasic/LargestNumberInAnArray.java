package arraybasic;

public class LargestNumberInAnArray {
	 public int largest(int arr[], int n)
	    {
	        int max = Integer.MIN_VALUE;
	        for(int i:arr)
	        {
	            max = Math.max(i,max);
	        }
	        return max;
	    }
}
