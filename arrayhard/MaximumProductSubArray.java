package arrayhard;


public class MaximumProductSubArray {
	 public int maxProduct(int[] nums) {
	        double max=nums[0];
	        double res=1;
	        for(int i:nums)
	        {
	            res*=i;
	            max=Math.max(res,max);
	            if(res==0)
	                res=1;
	        }
	        int length=nums.length-1;
	        res=1;
	        for(int i=length;i>=0;i--)
	        {
	            res*=nums[i];
	            max=Math.max(res,max);
	            if(res==0)
	                res=1;
	        }
	        return (int)max;
	        
	    }
}
