package census;

import java.util.Set;

public interface WordCensus {
	
	
	//pre: nothing
	public int getCount(String word);
	
	
	//part of pre: i > 0
	//part of post: i < getDistinctWords().size() ==> getCount(getWordWithRank(i)) >= getCount(getWordWithRank(i + 1))
	//part of post: [((i < j) && (word_i == getWordWithRank(i)) && (word_j == getWordWithRank(j))
	         // && (getCount(i) == getCount(j))] ==> (getWordWithRank(i) < getWordWithRank(j))
	public String getWordWithRank(int i);
	
	
	public Set<String> getDistinctWords();
}
