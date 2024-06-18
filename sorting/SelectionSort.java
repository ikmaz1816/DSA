package sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr= {10,9,8,7,6,4,3,2,1};
		selectionSort(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void selectionSort(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length;i++)
		{
			int min = i;
			for(int j=i+1;j<length;j++)
			{
				if(arr[min]>arr[j])
				{
					min=j;
				}
			}
			if(min == i)
				break;
			swap(arr,min,i);
		}
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
}
