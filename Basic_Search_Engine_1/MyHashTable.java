public class MyHashTable
{
	MyLinkedList<WordEntry> hash=new MyLinkedList<>();
	public int getHashIndex(String str)
	{
		Node<WordEntry> temp;
	  temp=hash.head;
	 // System.out.println(hash.head);
	  int z=0;
      while(temp!=null)
      {
      	if(temp.data.word.equals(str))
      	{
      		z= temp.data.l.head.data.wordIndex;
      	}
      	temp=temp.next;
      }
      	return z;
	}
	public WordEntry getWordEntry(String str)
	{
		//System.out.println("hemant5");
		Node<WordEntry> temp;
	  temp=hash.head;
	//  System.out.println("hemant1");
	 // System.out.println(temp);
	 // System.out.println("hemant1");
	 //System.out.println(temp.data.word);

	/* if(temp!=null&&temp.next!=null)
	  {
	  	System.out.println(temp.next.data.word);
	  }*/
      while(temp!=null)
      {
      	//System.out.println(temp.data.word);
      	
      	if(temp.data.word.equals(str))
      	{
      		//System.out.println("hemant4");
      		return temp.data;
      	}
      	temp=temp.next;
      	//System.out.println(temp);
      }
      	return null;
	}

	public void addPositionsForWord(WordEntry w)
	{
		//System.out.println("hemant5");
     
     if(this.getWordEntry(w.word)!=null)
      {
      	WordEntry temp=this.getWordEntry(w.word);
      	while(temp.bottom!=null)
      	{
      		temp=temp.bottom;
      	}
        temp.bottom=w;

      }
      else{
      //	WordEntry z=new WordEntry(w.word);
      //	z.addPositions(w.l);
      //	System.out.println("hemant5");
       	this.hash.Insert(w);
       	//System.out.println(hash.head.data.word);
      }
     // this.hash.Insert(w);
     
}
	//System.out.println(hash.head.next.data.word);
}