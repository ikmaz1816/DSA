package bitmanipulationbasic;

public class CheckForBit {
	static boolean checkKthBit(int n, int k)
    {
        int i = (1<<k);
        return (n&i) > 0 ? true : false;
    }
}
