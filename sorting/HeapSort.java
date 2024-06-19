package sorting;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr= {4, 3, 2, 1,10, 9, 8, 7, 6, 5};
		heapSort(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void heapSort(int[] arr) {
		
		int length = arr.length;
		for(int i = (length-1)/2;i>=0;i--)
		{
			downHeapify(arr,length,i);
		}
		
		for(int i=length-1;i>0;i--)
		{
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			downHeapify(arr,i,0);
		}
	}
	
	private static void downHeapify(int[] arr,int length,int parentindex)
	{
		int leftindex = 2 * parentindex + 1;
		int rightindex = 2 * parentindex + 2;
		while(leftindex < length)
		{
			int minindex = parentindex;
			if(arr[leftindex]>arr[minindex])
			{
				minindex = leftindex;
			}
			if(rightindex < length && arr[rightindex]>arr[minindex])
			{
				minindex = rightindex;
			}
			if(minindex == parentindex)
				break;
			int temp = arr[minindex];
			arr[minindex] = arr[parentindex];
			arr[parentindex] = temp;
			
			parentindex = minindex;
			leftindex = 2 * parentindex + 1;
			rightindex = 2 * parentindex + 2;
		}
	}
}
