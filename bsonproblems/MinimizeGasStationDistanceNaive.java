package bsonproblems;

public class MinimizeGasStationDistanceNaive {
	public static double findSmallestMaxDist(int arr[], int k) {
        
        int length = arr.length;
        int[] stepsTaken =  new int[length-1];
        
        for(int i=0;i<k;i++)
        {
            double max=0.0;
            int index =-1;
            for(int j=0;j<length-1;j++)
            {
                double value = (double)(arr[j+1]-arr[j])/(double)(stepsTaken[j]+1);
                if(max<value)
                {
                    max=value;
                    index =j;
                }
            }
            stepsTaken[index]++;
        }
        
        double ans = 0.0;
        for(int i=0;i<length-1;i++)
        {
            ans = Math.max(ans,(1.0*(arr[i+1]-arr[i]))/(double)(stepsTaken[i]+1));
        }
        return ans;
    }
}
