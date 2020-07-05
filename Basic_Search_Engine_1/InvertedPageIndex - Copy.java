public class InvertedPageIndex
{
	MyHashTable t=new MyHashTable();
	MySet<PageEntry> a=new MySet<>();
	public void addPage(PageEntry p)
	{
       // System.out.println(p.pagename+" enters");
       //System.out.println("hemant3");
    //PageEntry k=new PageEntry(p.b);
     Node<WordEntry> temp;
     temp=p.p.W.head;
    //System.out.println(temp.data.word);
     while(temp!=null)
     {
     // System.out.println("hemant4");
      t.addPositionsForWord(temp.data);
      temp=temp.next;
     }
    // System.out.println("hemant5");
	}
	public MySet<PageEntry> getPagesWhichContainWord(String str)
	{
     WordEntry temp=t.getWordEntry(str);
     //System.out.println(temp);
     if(temp==null)
     {
        System.out.println("No webpage contains word" +" " +str);
     }
     else{
     while(temp!=null)
     {
     	a.Insert(temp.l.head.data.p);
     	temp=temp.bottom;
     }
   }
     return a;
	}
}