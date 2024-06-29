package stringbasic;

public class CheckIfStringIsRotated {
	public boolean rotateString(String s, String goal) {
        if( s.length()!=goal.length())
            return false;
        s+=s;
        return  s.contains(goal);
    }
}
