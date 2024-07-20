package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public void getSubset(int sum,int group,int index,List<Integer> ans,List<List<Integer>> anslist)
    {
        if(sum==0)
        {
            if(ans.size()==group)
                anslist.add(new ArrayList<>(ans));
            return;
        }
        if(index==10)
        {
            if(sum==0)
            {
                if(ans.size()==group)
                    anslist.add(new ArrayList<>(ans));
            }
            return;
        }
        if(index<=sum)
        {
            ans.add(index);
            getSubset(sum-index,group,index+1,ans,anslist);
            ans.remove(ans.size()-1);
        }
        getSubset(sum,group,index+1,ans,anslist);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        getSubset(n,k,1,new ArrayList<>(),ans);
        return ans;
    }
}
