package binarysearchbasic;

public class SearchInsertPosition {
	public int searchInsert(int[] arr, int x) {
        int length = arr.length;
       int start = 0;
       int end = length-1;
       if(length!=0 && arr[end]<x)
       	return length;
       //if the first number is less than x then end would stop at -1 
       while(start<=end)
       {
           int mid = start + (end-start)/2;
           if(arr[mid]==x)
               return mid;
           else if(arr[mid]<x)
               start=mid+1;
           else
               end=mid-1;
       }
       return start;
   }
}
