package arraybasic;

public class SecondLargestNumberInAnArray {
	public int print2largest(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for(int i:arr)
        {
            max = Math.max(i,max);
        }
        int secondLargest = Integer.MIN_VALUE;
        for(int i:arr)
        {
            if(i!=max && secondLargest < i)
            {
                secondLargest = i;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
        
    }
}
