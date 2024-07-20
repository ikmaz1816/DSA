package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public void getSubset(int[] nums,int sum,int index,List<Integer> ans,List<List<Integer>> anslist)
    {
        if(sum==0)
        {
            anslist.add(new ArrayList<>(ans));
            return;
        }
        if(index==nums.length)
        {
            if(sum==0)
                anslist.add(new ArrayList<>(ans));
            return;
        }
        if(nums[index]<=sum)
        {
            ans.add(nums[index]);
            getSubset(nums,sum-nums[index],index+1,ans,anslist);
            ans.remove(ans.size()-1);
        }
        while(index<nums.length-1 && nums[index]==nums[index+1])
            index++;
        getSubset(nums,sum,index+1,ans,anslist);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        getSubset(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
}
