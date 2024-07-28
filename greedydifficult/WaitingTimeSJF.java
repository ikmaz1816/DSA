package greedydifficult;

import java.util.Arrays;

public class WaitingTimeSJF {
	static int solve(int bt[] ) {
        Arrays.sort(bt);
        int waiting=0,time=0;
        for(int i:bt)
        {
        	// Time taken by the process to get complete 
            // 1+2 +3 +4+7 =17
              time = time+i;
              //waiting time for the process
              //that is diff between both the process
              //1-1 = 0;
              //3-2 =1;
              //6-3 =3;
              //10-4 = 6;
              //17-7=10; => 20
            waiting+=time-i;
        }
        return waiting/bt.length;
	}
}
