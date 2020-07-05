
class Node{
Object data;
Node next;
Node(Object d,Node z)
{
data=d;
next=z;
}
}
public class Myset
{
	Node head;

public void Insert(Object d)
{
	Node temp=head;
	if(temp==null)
	{
		Node a=new Node(d,null);
        head=a;
	}
	else{
 	  	while(temp.next!=null)
		{
			temp=temp.next;
		}
		Node a=new Node(d,null);
		temp.next=a;
	}
}
public Boolean IsEmpty()
{
	if (head==null)
		return true;
	else
		return false;
}	
public Boolean IsMember(Object d)
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
public void Delete(Object d)
{
	Node temp=head;
	while(temp!=null)
	{
		if(temp.next.data==d)
		{
          temp.next=temp.next.next;
		}
		temp=temp.next;
		
	}
	

}
public Myset Union(Myset a)
{
	Myset c=new Myset();
  Node temp=head;
   while(temp!=null)
   {
   	c.Insert(temp.data);
   	temp=temp.next;
   }
   while(a.head!=null)
   {
   	c.Insert(a.head.data);
   	a.head=a.head.next;
   }
   return c;
}
public Myset Intersection(Myset a)
{
	Myset c=new Myset();
	Node temp=head;
	while(a.head!=null)
	{
	 while(temp!=null)
	 {	
	  if(a.head.data==temp.data)
	  {
        c.Insert(temp.data);
	  } 
	  temp=temp.next;
	 }
	 temp=head;
	 a.head=a.head.next;
	}
  return c;
}
}