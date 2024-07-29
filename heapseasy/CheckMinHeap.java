package heapseasy;

public class CheckMinHeap {
	public boolean countSub(long arr[], long n)
    {
        for(int i=(int)(n-1)/2;i>=0;i--)
        {
            int leftindex = 2 * i + 1;
            int rightindex = 2 * i + 2;
            if(leftindex < n && arr[leftindex]>arr[i])
                return false;
            if(rightindex < n && arr[rightindex]>arr[i])
                return false;
        }
        return true;
    }
}
