package greedydifficult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int[] i:intervals)
        {
            if(newInterval==null || i[1]<newInterval[0])
            {
                ans.add(i);
            }
            else if(i[0]>newInterval[1])
            {
                ans.add(newInterval);
                ans.add(i);
                newInterval=null;
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0],i[0]);
                newInterval[1] = Math.max(newInterval[1],i[1]);
            }
        }
        if(newInterval!=null)
            ans.add(newInterval); 
        return ans.toArray(new int[0][]);
    }
}
