package stackproblems;

public class NumberOfNgesToRight {
public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        
        int[] ans = new int[queries];
        for(int i=0;i<queries;i++)
        {
            ans[i] = count(N,arr,indices[i]);
        }
        return ans;
  }
  public static int count(int n,int[] arr,int index)
  {
      int count =0;
      for(int i=n-1;i>index;i--)
      {
          if(arr[index]<arr[i])
            count++;
      }
      return count;
  }
}
