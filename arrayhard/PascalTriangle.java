package arrayhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        if(numRows<=0)
            return new ArrayList<>();
        ans.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++)
        {
            int count=0;
            List<Integer> ls=new ArrayList<>();
            while(count<=i)
            {
                if(count==0 || count==i)
                {
                    ls.add(1);
                }
                else
                {
                    ls.add(ans.get(i-1).get(count)+ans.get(i-1).get(count-1));
                }
                count++;
            }
            ans.add(ls);
        }
        return ans;
    }
}
