public class Exchange
{
  public int id;
  MobilePhoneSet m;
  ExchangeList children= new ExchangeList();
  Exchange parent=null;
  Exchange(int number)
  {//children=new ExchangeList();
    id=number;
    m= new MobilePhoneSet();
    //Exchange parent=null;
  } 
  public Exchange parent()
  {
    return this.parent;
  }
  public int numchildren()
  {
    return this.children.size();
  }
  public Exchange child(int i)
  {
    return this.children.get(i );
  }
  public Boolean isRoot()
  {
    if(parent==null)
    return true;
    else
    return false;
  }
  public void Union()
  {
    for(int i=0;i<this.numchildren();i++)  
    {
      this.m.Union(this.child(i).m);
    }
  }
  public void print(Exchange p)
  {
    if(p.numchildren()==0)
    {
      p.m.print();
    }
    for(int i=0;i<p.numchildren();i++)
    {
      print(p.children.get(i));
    }
  }
  public RoutingMapTree subtree(int i)
  {
      RoutingMapTree r=new RoutingMapTree();
      r.root=this.child(i);

    
      /*r.root.id=children.get(i).id;
      r.root.children=children.get(i).children;
      r.root.parent=null;*/
     return r;
  }
  public MobilePhoneSet residentSet()
  {
    return m;
  }
}
  
