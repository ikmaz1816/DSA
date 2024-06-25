package maths;

import java.util.TreeSet;

public class PrintAllDivisorsOfANumber {
	public static void print_divisors(int n) {
	       TreeSet<Integer> set=new TreeSet<>();
	       for(int i=1;i*i<=n;i++)
	       {
	           if(n%i==0)
	           {
	               set.add(i);
	               set.add(n/i);
	           }
	       }
	       for(int i:set)
	       {
	           System.out.print(i+" ");
	       }
	    }
}
