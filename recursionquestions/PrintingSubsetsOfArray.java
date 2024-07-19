package recursionquestions;

import java.util.ArrayList;
import java.util.List;

public class PrintingSubsetsOfArray {
	public static void main(String[] args) {
		int[] arr=new int[]{1,2,2};
		printSubset(arr,0,new ArrayList<>());
		printSubset2(arr,0,new ArrayList<>());
	}

	private static void printSubset(int[] arr,int index,List<Integer> ans) {
		if(index==arr.length)
		{
			System.out.println(ans);
			return;
		}
		ans.add(arr[index]);
		printSubset(arr,index+1,ans);
		ans.remove(ans.size()-1);
		printSubset(arr,index+1,ans);
	}
	
	private static void printSubset2(int[] arr,int index,List<Integer> ans) {
		if(index==arr.length)
		{
			System.out.println(ans);
			return;
		}
		
		if(index<arr.length)
		{
			ans.add(arr[index]);
			printSubset2(arr,index+1,ans);
			ans.remove(ans.size()-1);
			
		}
		while(index<arr.length-1 && arr[index]==arr[index+1])
			index++;
		printSubset2(arr,index+1,ans);
	}
	
}
