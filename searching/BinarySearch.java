package searching;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		if(binarySearch(arr,1))
		{
			System.out.println("Element is present in the array");
		}
		else
		{
			System.out.println("Element is not present in the array");
		}
	}

	private static boolean binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while(start<=end)
		{
			int mid = (start+end)/2;
			
			if(arr[mid] == key)
			{
				return true;
			}
			else if(arr[mid] > key)
			{
				end = mid - 1;
			}
			else
			{
				start = mid + 1;
			}
		}
		return false;
	}
}
