package trie;

import java.util.ArrayList;

public class CheckPalindromicPair {
	public String reverse(String s)
    {
        String s1="";
        for(int i=s.length()-1;i>=0;i--)
        {
            s1+=s.charAt(i);
        }
        return s1;
    }
	public boolean isPalindromePair(ArrayList<String> words) {
		TrieImplementation implementation = new TrieImplementation();
//		4                -> sample input
//		abc def ghi cba
		for(int i=0;i<words.size();i++)
        {
            String s=words.get(i);
            for(int j=0;j<s.length();j++)
            {
            	//This is creating suffix trie
            	implementation.insert(s.substring(j));
            	//This is creating prefic trie
            	implementation.insert(s.substring(0,s.length()-1-j));
            }
        }
		for(String word : words)
        {
            if(implementation.search(word) && implementation.search(reverse(word)))
                return true;
        }
        return false;
    }
}
