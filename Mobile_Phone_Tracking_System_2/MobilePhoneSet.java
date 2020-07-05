public class MobilePhoneSet
{
  Myset a=new Myset();
  public void Insert(int number)
  {
    MobilePhone k=new MobilePhone(number);
    k.status=true;
    a.Insert(k);
  }
 
  public void Union(MobilePhoneSet b)
  {
   // MobilePhoneSet c=new MobilePhoneSet();
    this.a.Union(b.a);
  }
  public void print()
  {
   Node temp;
   temp=this.a.head;
    while(temp!=null)
    {
      MobilePhone p=(MobilePhone)temp.data;
      if(p.status==true)
      System.out.print(p.id+", ");
      temp=temp.next;
    }
  }
  public MobilePhone get(int i)
  {
    int n=0;
    Node temp;
    temp=this.a.head;
    MobilePhone u=null;
    for(n=0;n<i;n++)
    {
      temp=temp.next;
    }
   u=(MobilePhone)temp.data;
    return u;
  }
  public int size()
  {
    int n=0;
    Node temp;
    temp=this.a.head;
    while(temp!=null)
    {
      n=n+1;
      temp=temp.next;
    }
    return n;

  }
  public MobilePhone findphone(MobilePhone k)
  {
    //int j=0;
    Node temp;
    temp=this.a.head;
    MobilePhone u=null;
   // System.out.println("hemant");
    while(temp!=null)
    {
      // System.out.println("hemant");
       MobilePhone p=(MobilePhone)temp.data;
      if(p.id==k.id)
      {
        //System.out.println("hemant");
       // j=1;
        u= p;
      }
      temp=temp.next;
    }
    return u;
  } 
  public void delete(MobilePhone k)
  {
    Node temp;
    temp=this.a.head;
    while(temp!=null)
    {
       MobilePhone p=(MobilePhone)temp.data;
      if(p.id==k.id)
      {
        temp.next=temp.next.next;
      }
      temp=temp.next;
    }
  } 
}