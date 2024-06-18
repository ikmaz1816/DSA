package sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr= {-6,-4,1,0};
		insertionSort(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void insertionSort(int[] arr) {
		int length = arr.length;
		for(int i=1;i<length;i++)
		{
			int j=i;
			int temp = arr[j];
			while(j>0 && temp < arr[j-1])
			{
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}
		
	}
}
