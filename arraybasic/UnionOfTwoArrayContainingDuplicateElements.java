package arraybasic;

import java.util.ArrayList;

public class UnionOfTwoArrayContainingDuplicateElements {
	public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        int length1 = arr1.length;
        int length2 = arr2.length;
        boolean stopLoop=false;
        while(i<length1 && j<length2)
        {
            int size = ans.size();
            while(size>0 && ans.get(ans.size()-1)==arr1[i])
            {
                i++;
                if(i==length1)
                {
                    stopLoop = true;
                    break;
                }
            }
            while(size>0 && ans.get(ans.size()-1)==arr2[j])
            {
                j++;
                if(j==length2)
                {
                    stopLoop = true;
                    break;
                }
            }
            if(stopLoop)
                break;
            if(arr1[i]==arr2[j])
            {
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i]>arr2[j])
            {
                ans.add(arr2[j++]);
            }
            else
            {
                ans.add(arr1[i++]);
            }
        }
        while(i<length1)
        {
            int size = ans.size();
            if(!(size>0 && ans.get(ans.size()-1)==arr1[i]))
            {
                ans.add(arr1[i]);
            }
            i++;
        }
        while(j<length2)
        {
            int size = ans.size();
            if(!(size>0 && ans.get(ans.size()-1)==arr2[j]))
            {
                ans.add(arr2[j]);
            }
            j++;
        }
        return ans;
    }
}
