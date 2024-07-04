package stackproblems;

public class RainwaterTrapping {
	public int trap(int[] height) {
	       int length = height.length;
	       int left=0,right=length-1,maxLeft=0,maxRight=0;
	       int count=0;
	       while(left<right)
	       {
	          if(height[left]<=height[right])
	          {
	            if(height[left]>=maxLeft)
	            {
	                maxLeft = height[left];
	            }
	            else
	            {
	                count+=(maxLeft-height[left]);
	            }
	            left++;
	          }
	          else
	          {
	            if(height[right]>=maxRight)
	            {
	                maxRight = height[right];
	            }
	            else
	            {
	                count+=(maxRight-height[right]);
	            }
	            right--;
	          }
	        }
	       return count;
	    }
}
