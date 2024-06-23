package arraymedium;

import java.util.Arrays;

public class TwoSumWithSorting {
	public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;;
        int[] ans=new int[]{-1,-1};
        while(i<j)
        {
            if(nums[i]+nums[j]==target)
            {
                ans[0]=i;
                ans[1]=j;
                break;
            }
            else if(nums[i] + nums[j] > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return ans;
    }
}
