package arrayhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadSumtoTarget {
	public List<List<Integer>> fourSum(int[] nums, int target) {
	       List<List<Integer>> ans =new ArrayList<>();
	        int i=0;
	        int length=nums.length;
	        target=(int)target;
	        Arrays.sort(nums);
	        while(i<length)
	        {
	            while(i>0 && i<length && nums[i]==nums[i-1])
	                i++;
	            if(i>length-3)
	                break;
	            int j=i+1;
	            while(j<length)
	            {
	                while(j>i+1 && j<length && nums[j]==nums[j-1])
	                    j++;
	                if(j>length-2)
	                    break;
	                int k = j+1;
	                int v = length-1;
	                while(k<v)
	                {
	                    int value = nums[i]+nums[j]+nums[k]+nums[v];
	                    if(value==target)
	                    {
	                        List<Integer> ls = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[v]));
	                        ans.add(ls);
	                        k++;
	                        while(k<v && nums[k]==nums[k-1])
	                            k++;
	                        v--;
	                        while(k<v && nums[v]==nums[v+1])
	                            v--;  
	                    }
	                    else if(value>target)
	                    {
	                        v--;
	                    }
	                    else
	                        k++;

	                }
	                j++;
	            }
	           i++; 
	        }
	        return ans;
	    }
}
