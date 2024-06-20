package recursivesorting;

public class Quicksort {
	public static void main(String[] args) {
		int[] arr= {4, 3, 2, 1,10, 9, 8, 7, 6, 5};
//		int[] arr= {-6,-4,0,1};
		quicksort(arr,0,arr.length-1);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void quicksort(int[] arr, int start, int end) {
		if(start < end)
		{
			int pivot = partition(arr,start,end);
			quicksort(arr,start,pivot-1);
			quicksort(arr,pivot+1,end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = end;
		int theActualPivot = start-1;
		
		for(int i=start;i<end;i++)
		{
			if(arr[pivot] >= arr[i])
			{
				theActualPivot++;
				swap(arr,i,theActualPivot);
			}
		}
		
		theActualPivot++;
		swap(arr,theActualPivot,end);
		return theActualPivot;
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
}
