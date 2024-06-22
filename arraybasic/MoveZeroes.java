package arraybasic;

public class MoveZeroes {
	 public void moveZeroes(int[] nums) {
	        int i=-1;
	        int j = i+1;
	        int length = nums.length;
	        while(j<length)
	        {
	            if(nums[j] != 0)
	            {
	                i++;
	                int temp = nums[i];
	                nums[i] = nums[j];
	                nums[j] = temp;
	            }
	            j++;
	        }
	    }
}
