package arraymedium;

import java.util.HashMap;

public class SubArraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans = 0,sum=0;
        for(int i:nums)
        {
            sum+=i;
            if(map.containsKey(sum-k))
            {
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
