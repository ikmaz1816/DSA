package bsonproblems;

public class KthElementOfTwoSortedArrays {
	public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i=0,j=0;
        int count=1;
        //We will be using the principle of merging and during that process
        //if we come across a number where count == k this means that the number
        //is the kth element of the array
        while(i<n && j<m)
        {
            if(arr1[i]>=arr2[j])
            {
                if(count==k)
                    return arr2[j];
                j++;
            }
            else
            {
                if(count==k)
                    return arr1[i];
                i++;
            }
            count++;
        }
        //there are chances that i or j might have reached length
        while(i<n)
        {
            if(count==k)
                return arr1[i];
            i++;
            count++;
        }
        
        while(j<m)
        {
            if(count==k)
                return arr2[j];
            j++;
            count++;
        }
        return -1;
    }
}
