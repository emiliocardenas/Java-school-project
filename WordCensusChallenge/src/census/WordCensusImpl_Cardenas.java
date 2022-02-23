package census;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;



public class WordCensusImpl_Cardenas implements WordCensus
{
	private List<String> sortedListByCount;
	private Map<String, Long> wordToCountLinkedMap; //changed name map for better naming
													                          //convention(specific to this solution)
	
	
   // "Sorting" a hashmap by turning into list and sorting the list... Later converting into 
//	linkedList to keep sorted order. 
    private Map<String, Long> hashMapToSortedLinkedHashMap(Map<String, Long> map) 
    {
        List<Map.Entry<String, Long>> sortingList = new ArrayList<>(map.entrySet());

        // Sort list by integer values then by string keys
        Collections.sort(sortingList, (a, b) -> {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0) 
            {
                return cmp1;
            } 
            else 
            {
                return a.getKey().compareTo(b.getKey());
            }
        });

        Map<String, Long> sortedHash = new LinkedHashMap<>();
        for (Map.Entry<String, Long> entry : sortingList)
            sortedHash.put(entry.getKey(), entry.getValue());

        return sortedHash;
    }
    
	
	public WordCensusImpl_Cardenas(List<String> wordList)
	{	
		//replacing all the null values in the list to a string "nullReplace" b/c hashmaps cannot assign a null to a key.
		wordList.replaceAll(t -> Objects.isNull(t) ? "nullReplace" : t);

		Map<String, Long> wordToCountHashMap = 
				wordList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
		
		wordToCountLinkedMap = hashMapToSortedLinkedHashMap(wordToCountHashMap);
		
		sortedListByCount = new ArrayList<>();
		sortedListByCount.addAll(wordToCountLinkedMap.keySet());
	}
	 
	
		
	// post: return count of words.
	// post rv >= 0.
	public int getCount(String word) 
	{
		if(word == null)
		{
			word = "nullReplace";
		}
		long count = wordToCountLinkedMap.containsKey(word) ? wordToCountLinkedMap.get(word) : 0;

        return (int) count;
	}
	
	
	// post: NO DUPLICATE WORDS
	public Set<String> getDistinctWords() 
	{
		Set<String> hSet = new HashSet<String>(sortedListByCount);        
        return hSet;
	}
	

		
	//pre: List must be sorted by Rank
	//part of pre: i > 0
	//part of post: i < getDistinctWords().size() ==> getCount(getWordWithRank(i)) >= getCount(getWordWithRank(i + 1))
	//part of post: [((i < j) && (word_i == getWordWithRank(i)) && (word_j == getWordWithRank(j))
	         // && (getCount(i) == getCount(j))] ==> (getWordWithRank(i) < getWordWithRank(j))
	public String getWordWithRank(int i)
	{
		 assert i > 0 : "INVALID INPUT... PLEASE SEND A POSITIVE RANK";
	     assert i <= getDistinctWords().size() : "INVALID INPUT... RANK OUT OF RANGE";

		return sortedListByCount.get(i-1);
		
	}

}
