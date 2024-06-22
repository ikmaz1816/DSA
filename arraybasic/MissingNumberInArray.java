package arraybasic;

public class MissingNumberInArray {
	 public int missingNumber(int[] nums) {
	     int sum = 0;
	     int length = nums.length;
	     for(int i:nums)
	     {
	         sum+=i;
	     }
	     return (int)(Math.abs(sum - (length * (length+1)/2)));
	}	
}
