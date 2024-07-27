package twopointerslidingwindowhard;

import java.util.HashMap;

public class SubArrayWithKDifferentIntegers {
	public int subArray(int[] nums, int k)
    {
        int i=0,j=0,length=nums.length,ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<length)
        {
            if(!map.containsKey(nums[j]))
            {
                k--;
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(k<0)
            {
                int count = map.get(nums[i]);
                if(count==1)
                {
                    map.remove(nums[i]);
                    k++;
                }
                else
                    map.put(nums[i],count-1);
                i++;
            }
            j++;
            ans+=(j-i+1);
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums,k) - subArray(nums,k-1);
    }
}
