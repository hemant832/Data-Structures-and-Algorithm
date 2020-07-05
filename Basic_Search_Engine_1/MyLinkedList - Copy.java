public class MyLinkedList<T>
{
		Node<T> head;
	public void Insert(T d)
{

		Node<T> temp=head;
		if(temp==null)
		{
			Node<T> a=new Node<>(d,null);
    	    head=a;
		}
		else{
 		  	while(temp.next!=null)
			{
				temp=temp.next;
			}
			Node<T> a=new Node<>(d,null);
			temp.next=a;
		}
}
public Boolean IsMember(T d)
{ 
	Node temp=head;
	while(temp!=null)
	{
		if(temp.data==d)
		{
			return true;
		}
		temp=temp.next;
	}
		return false;
}
   public int size()
   {
   	int i=0;
   	Node<T> temp=head;
   	while(temp!=null)
   	{
      i=i+1;
      temp=temp.next;
   	}
   	return i;
   }
}