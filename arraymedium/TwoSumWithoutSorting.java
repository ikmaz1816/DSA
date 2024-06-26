package arraymedium;

import java.util.HashMap;

public class TwoSumWithoutSorting {
	 public int[] twoSum(int[] nums, int target) {
	       HashMap<Integer,Integer> map=new HashMap<>();
	       for(int i=0;i<nums.length;i++)
	       {
	            if(map.containsKey(target-nums[i]))
	            {
	                int firstindex = map.get(target-nums[i]);
	                return new int[]{firstindex,i};
	            }
	            map.put(nums[i],i);
	       }
	       return new int[]{-1,-1};
	    }
}
