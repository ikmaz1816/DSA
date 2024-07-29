package greedydifficult;

import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {
        int length = ratings.length;
        int[] ans = new int[length];
        Arrays.fill(ans,1);
        for(int i=1;i<length;i++)
        {
            if(ratings[i]>ratings[i-1])
                ans[i]=ans[i-1]+1;
        }
        for(int i=length-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i] && ans[i]>=ans[i-1])
                ans[i-1]=ans[i]+1;
        }
        return Arrays.stream(ans).sum();
    }
}
