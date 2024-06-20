package recursivesorting;

public class MergeSort {
	public static void main(String[] args) {
//		int[] arr= {4, 3, 2, 1,10, 9, 8, 7, 6, 5};
		int[] arr= {-6,-4,0,1};
		mergeSort(arr,0,arr.length);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void mergeSort(int[] arr,int start,int end) 
	{
		if(end-start==1)
			return;
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);
		merge(arr,start,mid,end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] ans=new int[end-start+1];
		int i=start;
		int j=mid;
		int k=0;
		while(i<mid && j<end)
		{
			if(arr[i] > arr[j])
			{
				ans[k++] = arr[j++];
			}
			else
			{
				ans[k++] = arr[i++];
			}
		}
		
		while(i<mid)
		{
			ans[k++] = arr[i++];
		}
		
		while(j<end)
		{
			ans[k++] = arr[j++];
		}
		for(int u=0;u<k;u++)
		{
			arr[u+start] = ans[u];
		}
	}
}
