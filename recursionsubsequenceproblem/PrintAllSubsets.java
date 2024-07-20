package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        getSubset(nums,0,new ArrayList<>(),list);
        return list;
    }

    public void getSubset(int[] nums,int index,List<Integer> ans,List<List<Integer>> anslist)
    {
        if(index==nums.length)
        {
            anslist.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        getSubset(nums,index+1,ans,anslist);
        ans.remove(ans.size()-1);
        getSubset(nums,index+1,ans,anslist);
    }
}
