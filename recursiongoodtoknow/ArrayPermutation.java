package recursiongoodtoknow;

public class ArrayPermutation {
	public static void main(String[] args) {
		int[] arr= {1,2,3};
		printAllPermutation(arr,0,arr.length-1);
	}

	private static void printAllPermutation(int[] arr, int i, int length) {
		if(i==length)
		{
			for(int j:arr)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		for(int k=i;k<=length;k++)
		{
			swap(arr,k,i);
			printAllPermutation(arr,i+1,length);
			swap(arr,k,i);
		}
		
	}

	private static void swap(int[] arr, int k, int i) {
		int temp = arr[k];
		arr[k]=arr[i];
		arr[i]=temp;
		
	}
}
