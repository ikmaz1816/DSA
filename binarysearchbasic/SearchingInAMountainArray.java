package binarysearchbasic;

public class SearchingInAMountainArray {
	public static int search(int[] arr, int target,int start,int end) {
		boolean isAsc = arr[start]<=arr[end];
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==target)
                return mid;
            else 
            {
                if(isAsc)
                {
                    if(arr[mid]>target)
                        end=mid-1;
                    else
                        start=mid+1;
                }
                 else
                {
                    if(arr[mid]>target)
                        end=mid-1;
                    else
                        start=mid+1;
                }
            }
           
        }
        return -1;
    }
	
	public static int findPeakElement(int[] nums) {
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
	
	public static void main(String[] args) {
		int[] arr=new int[] {1 ,2 ,3 ,9 ,7 ,8 ,6};
		int peak = findPeakElement(arr);
		int target = 2;
		int firstSearch = search(arr,target,0,peak);
		if(firstSearch==-1)
		{
			firstSearch=search(arr,target,peak+1,arr.length-1);
		}
		System.out.println(firstSearch);
	}
	
}
