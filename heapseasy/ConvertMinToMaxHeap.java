package heapseasy;

public class ConvertMinToMaxHeap {
	 static void convertMinToMaxHeap(int N, int arr[]) {
	        for(int i=(N-1)/2;i>=0;i--)
				downheapify(arr,i,N);

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
