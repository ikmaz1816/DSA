package binarysearchbasic;

import java.util.List;

public class FindRotationInArray {
	public int findKRotation(List<Integer> arr) {
        int pivot = findPivot(arr);
        return pivot==-1 ? 0 : pivot+1;
    }
    public int findPivot(List<Integer> arr)
    {
        int length =arr.size()-1;
        int start=0;
        int end = length;
        while(start<=end)
        {
            int mid = start+ (end-start)/2;
            if(mid<end && arr.get(mid)>arr.get(mid+1))
            {
                return mid;
            }
            else if(mid>start && arr.get(mid-1)>arr.get(mid))
                return mid-1;
            else if(arr.get(start)<arr.get(mid))
                start=mid+1;
            else 
                end=mid-1;
        }
        return -1;
    }
}
