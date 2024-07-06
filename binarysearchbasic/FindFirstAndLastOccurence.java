package binarysearchbasic;

public class FindFirstAndLastOccurence {
	public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if(length==0)
            return new int[]{-1,-1};
        int first = search(nums,target,true);
        int second = search(nums,target,false);
        return new int[]{first,second};
    }
    public int search(int[] arr, int target,boolean check) {
        int start = 0;
        int end = arr.length-1;
        int potentialAns=-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==target)
            {
                potentialAns=mid;
                if(check)
                    end=mid-1;
                else
                    start=mid+1;
            }
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
           
        }
        return potentialAns;
    }
}
