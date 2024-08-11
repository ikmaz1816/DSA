package minimumspanninganddisjoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AccountsMerge {
	@SuppressWarnings("unchecked")
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map=new HashMap<>();
        DisjointSetUnionBySize ds=new DisjointSetUnionBySize(accounts.size());
        int k=0;
        for(List<String> account:accounts)
        {
            for(int j=1;j<account.size();j++)
            {
                String s = account.get(j);
                if(!map.containsKey(s))
                {
                    map.put(s,k);
                }
                else
                {
                    int u=map.get(s);
                    ds.unionBySize(u,k);
                }
            }
            k++;
        }
        List<String>[] merged=new ArrayList[accounts.size()];
        for(int i=0;i<merged.length;i++)
            merged[i]=new ArrayList<>();
        for(String s:map.keySet())
        {
            int u = map.get(s);
            int parentU = ds.findParent(u);
            merged[parentU].add(s);
        }

        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<merged.length;i++)
        {
            if(merged[i].size()==0)
                continue;
            ArrayList<String> arr=new ArrayList<>();
            for(String s:merged[i])
            {
                arr.add(s);
            }
            Collections.sort(arr);
            arr.add(0,accounts.get(i).get(0));
            ans.add(new ArrayList<>(arr));
        } 
        return ans;
    }
}
