package bsonproblems;

public class CapacityToShipPackagesWithinDdays {
	public int shipWithinDays(int[] weights, int days) {
        int start=0;
        int end = 0;
        for(int i:weights)
        {
            end+=i;
            start=Math.max(start,i);
        }

        while(start<=end)
        {
            int mid = (start+end)/2;
            int daysTillMid = countDaysTillMid(weights,mid);
            if(daysTillMid>days)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }

    public int countDaysTillMid(int[] weights,int mid)
    {
        int count=1,sum=0;
        for(int i:weights)
        {
            if(sum+i>mid)
            {
                sum=i;
                count++;
            }
            else
                sum+=i;
        }
        return count;
    }
}
