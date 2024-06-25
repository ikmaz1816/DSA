package bitmanipulationbasic;

public class SetTheRightmostUnsetBit {
	static int setBit(int n) {
        if((n&1)==0)
            return n+1;
        int count = 0;
        int previousN=n;
        while(n>0)
        {
            count++;
            n>>=1;
            if((n&1)==0)
                break;
        }
        return previousN + (int)Math.pow(2,count);
    }
}
