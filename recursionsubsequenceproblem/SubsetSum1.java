package recursionsubsequenceproblem;

import java.util.ArrayList;

public class SubsetSum1 {
	ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        getSubset(arr,0,0,ans);
        return ans;
    }
    
    public void getSubset(ArrayList<Integer> arr,int index,int sum,ArrayList<Integer> ans)
    {
        if(index==arr.size())
        {
            ans.add(sum);
            return;
        }
        getSubset(arr,index+1,sum+arr.get(index),ans);
        getSubset(arr,index+1,sum,ans);
    }
}
