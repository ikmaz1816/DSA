package recursionquestions;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchFindAllPositionInArgumentArrayList {
	public static void main(String[] args) {
		int key=5;
		int[] arr=new int[]{1,5,2,3,4,5,7,8,9};
		System.out.println(linearSearchFindFirstPosition(arr,key,0,arr.length,new ArrayList<>()));
	}

	private static List<Integer> linearSearchFindFirstPosition(int[] arr,int key,int index,int length,List<Integer> ans) {
		if(index==length)
		{
			return ans;
		}
		if(arr[index]==key)
		{
			ans.add(index);
		}
		return linearSearchFindFirstPosition(arr,key,index+1,length,ans);
	}
	
}
