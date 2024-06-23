package arraymedium;

import java.util.Arrays;

public class RearrangePositiveAndNegative {
	  public int[] rearrangeArray(int[] nums) {
	        int[] positive = Arrays.stream(nums).filter(x->x>0).toArray();
	        int[] negative = Arrays.stream(nums).filter(x->x<0).toArray();
	        int k=0;
	        int i=0;
	        int j=0;
	        int length1=positive.length;
	        int length2=negative.length;
	        while(i<length1 && j<length2)
	        {
	            nums[k++]=positive[i++];
	            nums[k++]=negative[j++];
	        }
	        while(i<length1)
	        {
	            nums[k++]=positive[i++];
	        }
	        while(j<length2)
	        {
	            nums[k++]=negative[j++];
	        }
	        return nums;
	    }
}
