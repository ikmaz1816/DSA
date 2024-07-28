package greedydifficult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int start=intervals[0][0];
        int end = intervals[0][1];
        for(int[] i:intervals)
        {
            if(end>=i[0])
            {
                end=Math.max(end,i[1]);
            }
            else
            {
                ans.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[0][]);
    }
}
