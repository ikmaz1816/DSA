package basicrecursion;

public class ReverseAnArray {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		reverse(arr,0,arr.length-1);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
	}

	private static void reverse(int[] arr, int index, int length) {
		if(index==arr.length || index == length)
			return;
		int temp = arr[index];
		arr[index] = arr[length];
		arr[length] = temp;
		reverse(arr,index+1,length-1);
	}
}
