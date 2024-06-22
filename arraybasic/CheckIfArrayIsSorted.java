package arraybasic;

public class CheckIfArrayIsSorted {
	class Solution {
	    public boolean check(int[] nums) {
	        int length = nums.length;
	        for(int i = 1;i<length;i++)
	        {
	            if(nums[i]<nums[i-1])
	            {
	               return false;
	            }
	        }
	        return true;
	    }
	}
}
