package stringbasic;

public class ReverseEveryWordInAString {
	public String reverse(String s,int length)
    {
        String reverse="";
        for(int i=0;i<length;i++)
        {   
            char ch = s.charAt(i);
            char ch1 = i+1 < length ? s.charAt(i+1) : '*';
            if(ch==' ' && ch==ch1)
                continue;
            reverse = ch + reverse;
        }
        return reverse;
    }
    public String reverseWords(String s) {
        s=s.trim();
        int length = s.length();
        String rev=reverse(s,length);
        int revLength = rev.length();
        String finalReverse="";
        int j=0;
        for(int i=0;i<revLength;i++)
        {
            char ch = rev.charAt(i);
            if(ch==' ')
            {
                String partAnswer = rev.substring(j,i);
                finalReverse+=reverse(partAnswer,partAnswer.length())+" ";
                j=i+1;
            }
        }
        return finalReverse+reverse(rev.substring(j),rev.substring(j).length());
    }
}
