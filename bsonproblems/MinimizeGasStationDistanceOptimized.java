package bsonproblems;

public class MinimizeGasStationDistanceOptimized {
	
	public static double findSmallestMaxDist(int arr[], int k) {
        double start = 0.0;
        double end = 0.0;
        int length = arr.length;
        for(int i=0;i<length-1;i++)
        {
            end =Math.max((double)(arr[i+1]-arr[i]),end);
        }
        
        double epsilon = 1e-6;
        while(end-start>epsilon)
        {
            double mid = (start+end)/2.0;
            int count = getCountOfInBetween(arr,mid);
            if(count>k)
                start=mid;
            else
                end=mid;
        }
        return end;
    }
    
    public static int getCountOfInBetween(int[] arr,double distance)
    {
        int length = arr.length;
        int count=0;
        for(int i=1;i<length;i++)
        {
            /*
                Here if we look the arr[i]-arr[i-1] = 2-1=1 
                1/0.5 where 0.5 is mid the answer is 2 but the inbetween placed is 1
                Hence we check whether arr[i]-arr[i-1] == 2*0.5 
                If yes decrease the count
                Because it gives us +1 that we have to reduce
            */
            int inBetween = (int)((arr[i]-arr[i-1])/distance);
            if((arr[i]-arr[i-1]) == inBetween*distance)
            {
                inBetween--;
            }
            count+=inBetween;
        }
        return count;
    }
}
