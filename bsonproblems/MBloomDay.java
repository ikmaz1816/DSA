package bsonproblems;

public class MBloomDay {
	public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        /*
            In this question we have to make m bouquets with k consecutive elements
            If m*k is greater than length it is not possible
            The value at index specifies when the flower will bloom
            If k=2 it means that consecutive elements has to be bloomed to form a bouquet
            The search space is the minimum and maxmum value in the array
        */
        if(length < (long)m*k)
            return -1;
        int start=Integer.MAX_VALUE,end=Integer.MIN_VALUE;
        for(int i:bloomDay)
        {
            start = Math.min(start,i);
            end = Math.max(end,i);
        }

        while(start<=end)
        {
            int mid = (start+end)/2;
            int countOfBouquets = countConsecutiveBouquets(bloomDay,k,mid);
            if(countOfBouquets>=m)
            {
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return start;
    }

    public int countConsecutiveBouquets(int[] bloomDay,int k,int mid)
    {
        int countOfBouquets=0,countOfFlowers=0;
        for(int i:bloomDay)
        {
            if(i<=mid)
                countOfFlowers++;
            else
            {
                countOfBouquets+=(countOfFlowers/k);
                countOfFlowers=0;
            }
        }
        //There are chances that countOfFlowers is not zero and will be able to make one more bouquet
        countOfBouquets+=(countOfFlowers/k);
        return countOfBouquets;
    }
}
