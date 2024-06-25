package maths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationUsingSieve {
	 static List<Integer> findPrimeFactors(int N) {
	        List<Integer> ans=new ArrayList<>();
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
	           if(primeNumbers[i]==0)
	           {
	               while(N%i==0)
	               {
	                   ans.add(i);
	                   N/=i;
	               }
	           }
	       }
	       
	       return ans;
	    }
}	
