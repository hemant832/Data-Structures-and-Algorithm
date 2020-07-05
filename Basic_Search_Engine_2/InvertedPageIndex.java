public class InvertedPageIndex

{
	MyHashTable t=new MyHashTable();
    MySet<PageEntry> b=new MySet<>();
    int numberofpage=0;
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
     numberofpage=numberofpage+1;
    // System.out.println("hemant5");
	}
    public int numberofpagecontainword(String str)
    {
        int z=0;
        MySet<PageEntry> temp=this.getPagesWhichContainWord(str);
        while(temp.head!=null)
        {
            z=z+1;
            temp.head=temp.head.next;
        }
        return z;
    }
	public MySet<PageEntry> getPagesWhichContainWord(String str)
	{
        MySet<PageEntry> a=new MySet<>();
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
    public MySet<PageEntry> getPagesWhichContainPhrase(String str[])
    {
          MySet<PageEntry> temp2=new MySet<PageEntry>();
          MySet<PageEntry> temp=this.getPagesWhichContainWord(str[0]);
            for(int i=1;str[i]!=null;i++)
            {
               // System.out.println(" hemant");
                temp=temp.Intersection(this.getPagesWhichContainWord(str[i]));
            }
          /* MySet<PageEntry> temp3=temp;;
            while(temp3.head!=null)
                {
                    System.out.println(temp.head.data.pagename);
                    temp3.head=temp3.head.next;

                }*/
            while(temp.head!=null)
                {
                   // System.out.println(temp.head.data.numofphrase(str,this)+" yup");
                    if(temp.head.data.numofphrase(str,this)!=0)
                        temp2.Insert(temp.head.data);
                   temp.head=temp.head.next; 
                }
            return temp2;
}

}