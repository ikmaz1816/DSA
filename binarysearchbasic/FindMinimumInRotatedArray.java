package binarysearchbasic;

public class FindMinimumInRotatedArray {
	public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return pivot == -1 ? nums[0] : nums[pivot+1];
    }
     public int findPivot(int[] nums)
    {
        int length =nums.length-1;
        int start=0;
        int end = length;
        while(start<=end)
        {
            int mid = start+ (end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1])
            {
                return mid;
            }
            else if(mid>start && nums[mid-1]>nums[mid])
                return mid-1;
            else if(nums[start]<=nums[mid])
                start=mid+1;
            else 
                end=mid-1;
        }
        return -1;
    }
}
