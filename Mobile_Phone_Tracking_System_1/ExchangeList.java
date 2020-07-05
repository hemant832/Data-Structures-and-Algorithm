class Node1{
  Exchange obj;
  Node1 next;
  Node1(Exchange object,Node1 n)
  {
    obj=object;
    next=n;
  }
}
public class ExchangeList
{
  Node1 child=null;
public void add(Exchange p)
{
	Node1 temp=child;
	if(temp==null)
	{
		Node1 a=new Node1(p,null);
        child=a;
	}
	else{
	     while(temp.next!=null)
	      {
		    temp=temp.next;
	      }
         Node1 a=new Node1(p,null); 
         temp.next=a;
         }
     }
public Exchange get(int i)
{
	Node1 temp=child;
	for(int n=0;n<i;n++)
	{
		temp=temp.next;
	}
	return temp.obj;
}
public int size()
{
	int n=0;
	Node1 temp2=child;
	while(temp2!=null)
		{
			   n=n+1;
			temp2=temp2.next;
		}
		return n;
}
}