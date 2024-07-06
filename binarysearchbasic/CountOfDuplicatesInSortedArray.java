package binarysearchbasic;

public class CountOfDuplicatesInSortedArray {
	int count(int[] arr, int n, int target) {
        int length = arr.length;
        if(length==0)
            return 0;
        int first = search(arr,target,true);
        if(first==-1)
            return 0;
        int second = search(arr,target,false);
        return second-first+1;
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
