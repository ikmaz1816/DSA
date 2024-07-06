package binarysearchbasic;

public class FloorAndCeilInSortedArray {
	public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int length = a.length-1;
        int start=0;
        int end = a.length-1;
        boolean upperDoesntExist = false;
        if(a[length]<x)
          upperDoesntExist = true;
        while(start<=end)
        {
          int mid = start+ (end-start)/2;
          if(a[mid]== x)
          {
            return new int[]{a[mid],a[mid]};
          }
          else if(a[mid]<x)
            start = mid+1;
          else
            end = mid-1;
        }   
        if(upperDoesntExist)
          start=-1;
        if(start==-1 && end==-1)
          return new int[]{start,end};
        else if(start==-1)
          return new int[]{a[end],start};
        else if(end==-1)
          return new int[]{end,a[start]};
        return new int[]{a[end],a[start]};
    }
}
