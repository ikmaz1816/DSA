package recursionsubsequenceproblem;

public class CheckIfSubsetSumExist {
	public static boolean getSubset(int[] nums,int index,int sum)
    {
        if(index==nums.length)
        {
            if(sum==0)
                return true;
            else 
                return false;
        }
        return (nums[index]<=sum ? getSubset(nums,index+1,sum-nums[index]) : false) 
                            || getSubset(nums,index+1,sum);
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return getSubset(a,0,k);
    }
}
