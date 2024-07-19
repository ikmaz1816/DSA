package recursionquestions;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchFindAllPosition {
	public static void main(String[] args) {
		int key=5;
		int[] arr=new int[]{1,5,2,3,4,5,7,8,9};
		System.out.println(linearSearchFindFirstPosition(arr,key,0,arr.length));
	}

	private static List<Integer> linearSearchFindFirstPosition(int[] arr,int key,int index,int length) {
		ArrayList<Integer> ans=new ArrayList<>();
		if(index==length)
		{
			return ans;
		}
		if(arr[index]==key)
		{
			ans.add(index);
		}
		ans.addAll(linearSearchFindFirstPosition(arr,key,index+1,length));
		return ans;
	}
	
}
