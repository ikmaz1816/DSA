package recursionquestions;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,6};
		int key = -1;
		System.out.println(binarySearch(arr,key,0,arr.length-1));
	}

	private static int binarySearch(int[] arr, int key,int start,int end) {
		if(start>end)
			return -1;
		int mid =(start+end)/2;
		if(arr[mid]==key)
			return mid;
		else if(arr[mid]<key)
			return binarySearch(arr,key,mid+1,end);
		return binarySearch(arr,key,start,mid-1);
	}
}
