package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
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
        while(index<nums.length-1 && nums[index]==nums[index+1]) 
            index++;
        getSubset(nums,index+1,ans,anslist);
    }
}
