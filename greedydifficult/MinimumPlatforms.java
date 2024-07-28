package greedydifficult;

import java.util.Arrays;

public class MinimumPlatforms {
	/*
	 	Sorting the arrival and departure times independently without maintaining 
	 	the correspondence between arrivals and departures could lead to mismatched trains.
		However, the goal of the "Minimum Platforms" problem is to find the minimum number of platforms 
		required at the station such that no train waits, not necessarily tracking which specific train
		 occupies which platform. Therefore, sorting the arrays independently is a valid approach for solving 
		 this problem,as it helps us simulate the station's platform usage at any given point in time.
	 */
	static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count=0;
        int max=0,i=0,j=0;
        while(i<n && j<n)
        {
            if(arr[i]<=dep[j])
            {
                count++;
                max=Math.max(count,max);
                i++;
            }
            else
            {
                count--;
                j++;
            }
        }
        return max;
    }
}
