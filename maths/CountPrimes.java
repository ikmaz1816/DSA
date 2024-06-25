package maths;

import java.util.Arrays;

public class CountPrimes {
	//In this question we have to find all prime numbers less than N
	public int countPrimes(int N) {
        boolean[] primeNumbers = new boolean[N];
        Arrays.fill(primeNumbers,true);
        for(int i=2;i*i<N;i++)
        {
            for(int j=i*2;j<N;j+=i)
            {
                primeNumbers[j] = false;
            }
        }
        int count=0;
        for(int i=2;i<N;i++)
        {
            if(primeNumbers[i])
                count++;
        }
        return count;
    }
}
