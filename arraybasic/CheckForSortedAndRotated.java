package arraybasic;

public class CheckForSortedAndRotated {
	 public boolean check(int[] nums) {
	        int length = nums.length;
	        int count =0;
	        for(int i=0;i<length-1;i++)
	        {
	            if(nums[i] > nums[i+1])
	                count++;
	        }
	        if(nums[0] < nums[length-1])
	            count++;
	        return count<=1;
	    }
}
