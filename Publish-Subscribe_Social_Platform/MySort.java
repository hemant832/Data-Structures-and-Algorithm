import java.util.*;
public class MySort{
	ArrayList<SearchResult> sortThisList(MySet<SearchResult> listOfSortableEntries)
	{
		ArrayList<SearchResult> list=new ArrayList<SearchResult>();
		Node<SearchResult> temp=listOfSortableEntries.head;
		while(temp!=null)
		{
			list.add(temp.data);
			temp=temp.next;
		}
		Collections.sort(list);
		return list;
	}
}