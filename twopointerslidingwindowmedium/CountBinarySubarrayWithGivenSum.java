package twopointerslidingwindowmedium;

public class CountBinarySubarrayWithGivenSum {
	public int sum(int[] nums, int goal)
    {
        int i=0,j=0,length=nums.length;
        int sum=0,ans=0;
        while(j<length)
        {
            sum+=nums[j];
            //The reason no to check for sum==goal is to just find subarrays with this given goal
            while(i<=j && sum>goal)
            {
                sum-=nums[i];
                i++;
            }
            j++;
            ans+=(j-i+1);
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sum(nums,goal) - sum(nums,goal-1);
    }
}
