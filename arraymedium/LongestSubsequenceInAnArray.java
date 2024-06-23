package arraymedium;

import java.util.HashMap;

public class LongestSubsequenceInAnArray {
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   HashMap<Integer,Integer> map=new HashMap<>();
	   int index=0;
	   for(int i:arr)
	   {
	       map.put(i,index++);
	   }
	   int count=0,maxCount=0;
	   for(int i:arr)
	   {
	       while(map.containsKey(i))
	       {
	           count++;
	           i++;
	       }
	       maxCount=Math.max(count,maxCount);
	       count=0;
	   }
	   return maxCount;
	}
}
