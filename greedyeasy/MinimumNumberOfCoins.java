package greedyeasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfCoins {
	static List<Integer> minPartition(int N)
    {
        List<Integer> ans = new ArrayList<>();
        List<Integer> currency=new ArrayList<>(
            Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000));
        int i=currency.size()-1;
        while(N>0 && i>=0)
        {
            int amount = currency.get(i);
            if(amount<=N)
            {
                N-=amount;
                ans.add(amount);
                continue;
            }
            i--;
        }
        return ans;
    }
}
