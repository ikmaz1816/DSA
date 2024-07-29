package greedydifficult;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,(a,b)->a[1]-b[1]);
       int end = intervals[0][1];
       int count=0;
       for(int[] i:intervals)
       {
           if(end>i[0])
           {
               count++;
           }
           else
           {
               end=i[1];
           }
       }
       return count-1;
   }
}
