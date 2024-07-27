package twopointerslidingwindowmedium;

public class MaximumConsecutiveOnes3 {
	public int longestOnes(int[] nums, int k) {
        int i=0,j=0,length=nums.length,max=0;
        while(j<length)
        {
            if(nums[j]==0)
                k--;
            while(k<0)
            {
                if(nums[i]==0)
                    k++;
                i++;
            }

            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
