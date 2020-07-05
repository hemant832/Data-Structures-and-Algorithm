public class PageIndex
{
	MyLinkedList<WordEntry> W=new MyLinkedList<>();
	public WordEntry findwordentry(String str)
	{
     // Node<WordEntry> temp=W.head;
		Node<WordEntry> temp;
	  temp=W.head;
      while(temp!=null)
      {
      	if(temp.data.word.equals(str))
      	{
      		return temp.data;
      	}
      	temp=temp.next;
      }
      	return null;
	}
	  public void addPositionForWord(String str, Position p){ 
         // System.out.println("hemant3");
          if(findwordentry(str)!=null)
          {
          	findwordentry(str).addPosition(p);

           // W.Insert(findwordentry(str));
          }
          else
          {
          	WordEntry w=new WordEntry(str);
          	w.addPosition(p);
          	W.Insert(w);
          	
          }


			
		}
     public void addPositionForWord2(String str, Position p){ 
         // System.out.println("hemant3");
          if(findwordentry(str)!=null)
          {
            findwordentry(str).addPosition2(p);

           // W.Insert(findwordentry(str));
          }
          else
          {
            WordEntry w=new WordEntry(str);
            w.addPosition2(p);
            W.Insert(w);
            
          }


      
    }


    public void addPositionForWordavl(String str, Position p){ 
         //System.out.println("hemant3");
          if(findwordentry(str)!=null)
          {
            findwordentry(str).addPositionavl(p);

           // W.Insert(findwordentry(str));
          }
          else
          {
            WordEntry w=new WordEntry(str);
            w.addPositionavl(p);
            W.Insert(w);
            
          }
          

      
    }
	  public MyLinkedList<WordEntry> getWordEntries()
		{
          return W;
		}
}

