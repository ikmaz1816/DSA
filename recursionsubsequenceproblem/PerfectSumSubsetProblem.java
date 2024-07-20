package recursionsubsequenceproblem;

public class PerfectSumSubsetProblem {
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    return getSubset(arr,0,sum);
	} 
	
	public int getSubset(int[] nums,int index,int sum)
    {
        if(index==nums.length)
        {
            if(sum==0)
                return 1;
            return 0;
        }
        int count=0;
        if(nums[index]<=sum)
        {
            count+=getSubset(nums,index+1,sum-nums[index]);
        }
        count+=getSubset(nums,index+1,sum);
        return count;
    }
}
