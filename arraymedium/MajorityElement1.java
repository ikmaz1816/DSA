package arraymedium;

public class MajorityElement1 {
	 public int majorityElement(int[] nums) {
	        int count = 0;
	        int element = Integer.MIN_VALUE;
	        for(int i:nums)
	        {
	            if(count==0)
	            {
	                count++;
	                element = i;
	            }
	            else if(i!=element)
	            {
	                count--;
	            }
	            else
	            {
	                count++;
	            }
	        }
	        count = 0;
	        for(int i:nums)
	        {
	            if(element==i)
	                count++;
	        }

	        return count >= nums.length/2 ? element : -1;	   
	    }
}
