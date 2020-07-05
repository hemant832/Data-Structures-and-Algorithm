import java.util.*;
public class SearchResult implements Comparable<SearchResult>{
	String text;
	int time;
	SearchResult(String text, int time)
	{
		this.text=text;
		this.time=time;
	}
	/*public PageEntry getPageEntry()
	{
		return p;
	}
	public float getRelevance()
	{
		return r;
	}*/
	public int compareTo(SearchResult otherObject)
	{
		if(this.time<otherObject.time)
			return -1;
		else
			return 1;
	}
	

}