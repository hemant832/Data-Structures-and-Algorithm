public class WordEntry
{
	String word;
	//int index;
    //PageEntry p;
    MyLinkedList<Position> l=new MyLinkedList<>();
    WordEntry bottom;

	WordEntry(String word)
	{
      this.word=word;
	}
	public void addPosition(Position position)
	{
		this.l.Insert(position);
      //this.index=position.wordIndex;
      //this.p=position.p;
	}
	public void addPositions(MyLinkedList<Position> positions)
	{
		//Node<Position> temp=l.head;
      while(positions.head!=null)
      {
      	/*this.l.temp.addPosition(positions.head);
      	temp=temp.next;*/
      	this.l.Insert(positions.head.data);
      	positions.head=positions.head.next;

      }
	}
	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
     return l;
	}
	/*float getTermFrequency(String word)
	{

	}*/
}