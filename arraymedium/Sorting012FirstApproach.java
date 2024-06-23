package arraymedium;

public class Sorting012FirstApproach {
	public void sortColors(int[] nums) {
	       int zero = 0;
	       int one = 0;
	       int two = 0;
	       for(int i:nums)
	       {
	        if(i==0)
	            zero++;
	        else if(i==1)
	            one++;
	        else 
	            two++;
	       }
	       int countOfOne=zero+one,countOfTwo=countOfOne+two;
	       for(int i=0;i<zero;i++)
	       {
	          nums[i] = 0;
	       }
	       for(int i=zero;i<countOfOne;i++)
	       {
	          nums[i] = 1;
	       }
	       for(int i=countOfOne;i<countOfTwo;i++)
	       {
	          nums[i] = 2;
	       }
	    }
}
