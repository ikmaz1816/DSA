package arraymedium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {
	static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            max=Math.max(arr[i],max);
            if(max<=arr[i])
                ans.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
