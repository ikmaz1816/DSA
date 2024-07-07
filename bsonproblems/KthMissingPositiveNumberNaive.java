package bsonproblems;

public class KthMissingPositiveNumberNaive {
	public int findKthPositive(int[] arr, int k) {
        int count=k;
        //If starting is 3 k=2 then the missing number is 2 
        if(k<arr[0])
            return k;
        for(int i:arr)
        {
            if(i<=count)
                count++;
            else
                break;
        }
        /*
            2,3,4,7,11 k=5
            2<=5  count++ count =6
            3<=6 count =7
            4<=7 count=8
            7<=8 count=9
            11<=9 return count
         */

        return count;
    }
}
