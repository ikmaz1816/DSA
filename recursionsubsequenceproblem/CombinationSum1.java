package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
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
            getSubset(nums,sum-nums[index],index,ans,anslist);
            ans.remove(ans.size()-1);
        }
        getSubset(nums,sum,index+1,ans,anslist);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        getSubset(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
}
