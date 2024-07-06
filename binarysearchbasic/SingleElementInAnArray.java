package binarysearchbasic;

public class SingleElementInAnArray {
	public int singleNonDuplicate(int[] nums) {
        int length=nums.length;
        int start=0;
        int end = length-1;
        while(start<end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]==nums[mid^1])
                start=mid+1;
            else
                end=mid;
        }
        return nums[end];
    }
}
