package trie;

import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        TrieImplementation trie=new TrieImplementation();
        for(int i=0;i<wordDict.size();i++)
        {
            trie.insert(wordDict.get(i));
        }
        return trie.wordBreak(s);
    }
}
