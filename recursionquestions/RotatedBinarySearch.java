package recursionquestions;

public class RotatedBinarySearch {
	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,6};
		int key = 6;
		System.out.println(rotatedBinarySearch(arr,key,0,arr.length-1));
	}

	private static int rotatedBinarySearch(int[] arr, int key, int start, int end) {
		if(start>end)
			return -1;
		int mid =(start+end)/2;
		if(arr[mid]==key)
			return mid;
		if(arr[start]<=arr[mid])
		{
			if(arr[start]<=key && key<=arr[mid])
                return rotatedBinarySearch(arr,key,start,mid-1);
            else
                return rotatedBinarySearch(arr,key,mid+1,end);
		}
        if(arr[mid]<=key && arr[end]>=key)
            return rotatedBinarySearch(arr,key,mid+1,end);
        return rotatedBinarySearch(arr,key,start,mid-1);
		
	}
}
