package heapseasy;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr=new int[] {5,4,3,2,1};
		heapsort(arr,arr.length);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
	}

	private static void heapsort(int[] arr, int length) {
		for(int i=(length-1)/2;i>=0;i--)
			downheapify(arr,i,length);
		for(int i=length-1;i>=0;i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			downheapify(arr,0,i);
		}
	}
	
	private static void downheapify(int[] arr,int parentIndex,int length) {
		int leftindex = parentIndex * 2 + 1;
		int rightindex = parentIndex * 2 + 2;
		while(leftindex<length)
		{
			int maxindex = parentIndex;
			if(arr[maxindex]<arr[leftindex])
				maxindex = leftindex;
			if(rightindex<length && arr[maxindex]<arr[rightindex])
				maxindex = rightindex;
			if(maxindex == parentIndex)
				break;
			int temp =arr[maxindex];
			arr[maxindex] = arr[parentIndex];
			arr[parentIndex] = temp;
			parentIndex = maxindex;
			leftindex = parentIndex * 2 + 1;
			rightindex = parentIndex * 2 + 2;
		}
	}
}
