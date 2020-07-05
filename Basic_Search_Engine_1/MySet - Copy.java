
class Node<T>{
T data;
Node<T> next;
Node(T d,Node<T> z)
{
data=d;
next=z;
}
}
public class MySet<T>
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
public Boolean IsEmpty()
{
	return (head==null);
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
public void Delete(T d)
{
	Node<T> temp=head;
	while(temp!=null)
	{
		if(temp.next.data==d)
		{
          temp.next=temp.next.next;
		}
		temp=temp.next;
		
	}
	

}
public MySet<T> Union(MySet<T> a)
{
	MySet<T> c=new MySet<>();
  Node<T> temp=head;
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
public MySet Intersection(MySet<T> a)
{
	MySet<T> c=new MySet<>();
	Node<T> temp=head;
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