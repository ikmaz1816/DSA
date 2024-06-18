package sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr= {3,2,1,4,5};
		bubbleSort(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void bubbleSort(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length-1;i++)
		{
			boolean flag = true;
			for(int j=0;j<length-i-1;j++)
			{
				if(arr[j] > arr[j+1])
				{
					swap(arr,j,j+1);
					flag = false;
				}
			}
			if(flag)
				break;
		}
		
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
}
