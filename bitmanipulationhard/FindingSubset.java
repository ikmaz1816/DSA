package bitmanipulationhard;

import java.util.ArrayList;
import java.util.List;

public class FindingSubset {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls =new ArrayList<>();

        int loopToBeExecutedTimes = (int)Math.pow(2,nums.length);
        for(int i=0;i<loopToBeExecutedTimes;i++)
        {
            List<Integer> ans =new ArrayList<>();
            for(int j=0;j<nums.length;j++)
            {
                if((i&(1<<j))!=0)
                {
                    ans.add(nums[j]);
                }
            }
            ls.add(ans);
        }
        return ls;
    }
}
