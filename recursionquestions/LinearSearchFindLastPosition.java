package recursionquestions;

public class LinearSearchFindLastPosition {
	public static void main(String[] args) {
		int key=5;
		int[] arr=new int[]{1,5,2,3,4,5,7,8,9};
		System.out.println(linearSearchFindFirstPosition(arr,key,arr.length-1));
	}

	private static int linearSearchFindFirstPosition(int[] arr,int key,int index) {
		if(index==-1)
		{
			return -1;
		}
		if(arr[index]==key)
			return index;
		return linearSearchFindFirstPosition(arr,key,index-1);
	}
	
}
