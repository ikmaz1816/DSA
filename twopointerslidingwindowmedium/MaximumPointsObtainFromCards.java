package twopointerslidingwindowmedium;

public class MaximumPointsObtainFromCards {
	public int maxScore(int[] arr, int k) {
        int sumLeft=0;
        for(int i=0;i<k;i++)
        {
            sumLeft+=arr[i];
        }

        int sumRight=0,max=sumLeft;
        int length = arr.length-1;
        for(int i=k-1,j=length;i>=0;i--,j--)
        {
            sumLeft-=arr[i];
            sumRight+=arr[j];
            max=Math.max(sumLeft+sumRight,max);
        }
        return max;
    }
}
