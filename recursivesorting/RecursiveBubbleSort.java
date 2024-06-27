package recursivesorting;

public class RecursiveBubbleSort {
	public static void main(String[] args) {
		int[] arr= {4, 3, 2, 1,10, 9, 8, 7, 6, 5};
		recursiveBubbleSort(arr,arr.length-1,0);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	
	
	private static void recursiveBubbleSort(int[] arr, int r, int c) {
		if(r == 0)
			return;
		if(c == r)
		{
			recursiveBubbleSort(arr,r-1,0);
			return;
		}
		if(arr[c] > arr[c+1])
		{
			swap(arr,c,c+1);
		}
		recursiveBubbleSort(arr,r,c+1);
	}



	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
}
