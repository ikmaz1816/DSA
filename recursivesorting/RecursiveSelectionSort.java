package recursivesorting;

public class RecursiveSelectionSort {
	public static void main(String[] args) {
		int[] arr= {4, 3, 2, 1,10, 9, 8, 7, 6, 5};
		recursiveSelectionSort(arr,arr.length,0,0);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void recursiveSelectionSort(int[] arr, int r, int c, int maxIndex) 
	{
		if(r == 0)
			return;
		if(c == r)
		{
			swap(arr,r-1,maxIndex);
			recursiveSelectionSort(arr,r-1,0,0);
			return;
		}
		if(arr[c] > arr[maxIndex])
		{
			recursiveSelectionSort(arr,r,c+1,c);
		}
		else
		{
			recursiveSelectionSort(arr,r,c+1,maxIndex);
		}
	}


	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
}
