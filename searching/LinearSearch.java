package searching;

public class LinearSearch {
	public static void main(String[] args) {
		int[] arr= {4,5,1,2,3};
		if(linearSearch(arr,-1))
		{
			System.out.println("Element is present in the array");
		}
		else
		{
			System.out.println("Element is not present in the array");
		}
	}

	private static boolean linearSearch(int[] arr, int key) {
		int length = arr.length;
		for(int i=0;i<length;i++)
		{
			if(arr[i] == key)
				return true;
		}
		
		return false;
	}
}
