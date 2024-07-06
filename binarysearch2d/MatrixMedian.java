package binarysearch2d;

public class MatrixMedian {
	int median(int matrix[][], int R, int C) {
        int start=1,end=2000;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            int count = 0;
            for(int i=0;i<R;i++)
            {
                count+=upperBound(matrix[i],C,mid);
            }
            /*
                in the above case the start and end was initialized on the basis
                of constraints given
                We have to find how many elements are less than or equal to the number
                With this we see the if the count if execeeds the median index then 
                decrease the upper constraint or increase the lower constraint
            */
            if(count<=(R*C)/2)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }
    
    int upperBound(int[] arr,int length,int target)
    {
        //similar to upper bound implementation
        int start = 0;
        int end = length-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(arr[mid]<=target)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }
}
