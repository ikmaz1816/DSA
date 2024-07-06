package binarysearchbasic;

public class FindingPeakElementInArray {
	// It is increasing and then decreasing array
	// 1 2 3 9 7 8 6
	public int findPeakElement(int[] nums) {
        int length=nums.length;
        int start=0;
        int end = length-1;
        while(start<end)
        {
           int mid = start+(end-start)/2;
           if(nums[mid]<nums[mid+1])
                start = mid+1;
            else 
                end = mid;
        }
        return end;
    }
}
