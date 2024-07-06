package binarysearchbasic;

public class UnSortedFloorCeil {
	class Pair
	{
		int floor;
		int ceil;
		public Pair(int floor,int ceil)
		{
			this.floor=floor;
			this.ceil=ceil;
		}
	}
	Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        //The array is not sorted
        int floor=-1,ceil=-1;
        for(int i=0;i<n;i++)
        {
            if(x==arr[i])
                return new Pair(arr[i],arr[i]);
            if(x>arr[i] && floor<arr[i])
            {
                floor=arr[i];
            }
            if(x<arr[i] && (ceil>arr[i] || ceil==-1))
            {
                ceil=arr[i];
            }
        }
        return new Pair(floor,ceil);
    }
}
