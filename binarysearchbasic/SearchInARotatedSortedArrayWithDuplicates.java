package binarysearchbasic;

public class SearchInARotatedSortedArrayWithDuplicates {
	public boolean search(int[] nums, int target) {
        int length = nums.length-1;
        int pivot = findPivot(nums);
        if(pivot==-1)
        {
            return search(nums,target,0,length);
        }
        else if(nums[pivot]==target)
            return true;
        else if(target>=nums[0])
            return search(nums,target,0,pivot-1);
        return search(nums,target,pivot+1,length);
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
            else if(nums[start]==nums[mid] && nums[mid]==nums[end])
            {
                if(start<mid && nums[start]>nums[start+1])
                    return start;
                start++;

                if(end>mid && nums[end]<nums[end-1])
                    return end-1;
                end--;
            }
            else if(nums[start]<=nums[mid])
                start=mid+1;
            else 
                end=mid-1;
        }
        return -1;
    }
     public boolean search(int[] arr, int target,int start,int end) {
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
           
        }
        return false;
    }
}
