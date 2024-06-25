package maths;

import java.util.TreeSet;

public class PrintAllPrimeFactorsOfANumber {
	 public int[] AllPrimeFactors(int N)
	    {
	       TreeSet<Integer> ans=new TreeSet<>();
	       int[] primeNumbers=new int[N+1];
	       for(int i=2;i*i<=N;i++)
	       {
	           for(int j=i*2;j<=N;j+=i)
	           {
	               primeNumbers[j]=-1;
	           }
	       }
	       
	       for(int i=2;i<=N;i++)
	       {
	           if(N%i==0)
	           {
	               if(primeNumbers[i]==0)
	               {
	                   ans.add(i);
	               }
	               if(primeNumbers[N/i]==0 && i!=N)
	               {
	                   ans.add(N/i);
	               }
	           }
	       }
	       
	       return ans.stream().mapToInt(i->i).toArray();
	    }
}
