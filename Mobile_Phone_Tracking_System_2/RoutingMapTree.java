import java.util.Scanner;

public class RoutingMapTree
{
   Exchange root = new Exchange(0);
  public RoutingMapTree()
  {
  root=new Exchange(0);
  }
  public RoutingMapTree(Exchange a){
    root=a;

  }
  
  public RoutingMapTree(int a){
    root=new Exchange(a);

  }
  //root.parent=null;
  
public void switchOn(int id, Exchange b)
{
  MobilePhone a=new MobilePhone(id);
  a.status=true;
  b.m.Insert(id);
  Update(b,id);

}
/*public void switchOff(MobilePhone a)
{
  a.status=false;
  a.bs=null;
}*/
public void addExchange(Exchange a,int id)
{
  Exchange b=new Exchange(id);
b.parent=a;
a.children.add(b);
//System.out.println(a.children.size()); 
}


public Exchange find(int f)
{
// int i=e.children.size()-1;
 // System.out.println(e);
/*  int i=0;
  if(e.id==f)
  {
   E= e;
  return E;
  }
  if(e.numchildren()==0)
  {
    return E;
  }
  else{
  while(i<e.numchildren()&&E==null)
  {
    e=e.child(i);
    E=find(f);
    i=i+1;
  }  
}
return E;*/
Exchange E=null;
Exchange e=root;
 if(root.id==f)
  {
   E= e;
   }
   else if(e.numchildren()!=0)
    {
      for(int i=0;i<root.numchildren()&&E==null;i++)
      {
       if(e.subtree(i).find(f)!=null)
       {
         E=e.subtree(i).find(f);
       }
     }
     }
     //System.out.println("hemant");
   return E;


}
public void switchOff(MobilePhone f)
{
  //System.out.println("hemant");
  //Exchange E=null;
Exchange e=root;
if(e.m.findphone(f)!=null)
{
  e.m.findphone(f).status=false;
}
if(e.numchildren()==0)
{
  if(e.m.findphone(f)!=null)
{
  e.m.findphone(f).status=false;
 // Update(e,f.id);
}
else
return;
}
 if(e.numchildren()!=0)
    {
      for(int i=0;i<e.numchildren();i++)
      {
         e.subtree(i).switchOff(f);
     }
     }
     //System.out.println("hemant");*/
}
public Exchange findphone2(MobilePhone m)
{
  Exchange E=null;
Exchange e=root;
if(e.numchildren()==0)
{
  if(e.m.findphone(m)!=null&&e.m.findphone(m).status==true)
  {
    E=e;
  }
}

   else if(e.numchildren()!=0)
    {
      for(int i=0;i<root.numchildren()&&E==null;i++)
      {
       if(e.subtree(i).findphone2(m)!=null)
       {
         E=e.subtree(i).findphone2(m);
       }
     }
     }
     //System.out.println("hemant");
   return E;
}
public Exchange lowestRouter(Exchange a, Exchange b)
{
  Exchange E=null;
  Exchange temp=a;
  if(a!=null&&b!=null)
{
  if(a.id==b.id)
  {
    E=a;
  }
  while(b.parent!=null&&E==null)
  {
    while(a.parent!=null&&E==null)
    {

      if(b.parent.id==a.parent.id)
      {
        E=b.parent;
      }
      a=a.parent;
    }
    b=b.parent;
    a=temp;
  }
}
  return E;
}
public void movePhone(MobilePhone a, Exchange b)
{
  Exchange E=findphone2(a);
  this.switchOff(a);
  this.switchOn(a.id,b);
}
public ExchangeList routeCall(MobilePhone a, MobilePhone b)
{
  Exchange x=findphone2(a);
  Exchange y=findphone2(b);
 // System.out.println(y+"hemant");
  Exchange z=lowestRouter(x,y);
  ExchangeList q=new ExchangeList();
  ExchangeList w=new ExchangeList();
  ExchangeList e=new ExchangeList();
  while(x!=z)
  {
    q.add(x);
    x=x.parent;
  }
  q.add(z);
  while(y!=z)
  {
    y.parent.tempchild=y;
    y=y.parent;
}
while(z.tempchild!=null)
{
  q.add(z.tempchild);
  z=z.tempchild;
}
return q;
}



/*if(e.numchildren()==0)
{
   MobilePhone k=new MobilePhone(f);
int z=e.m.findphone(k);
if(z==1)
{
  //MobilePhone k=new MobilePhone(f);
  e.m.delete(k);
  Updatedelete(e,f);
}
else
System.out.println("not found");
}
    if(e.numchildren()!=0)
    {
      for(int i=0;i<root.numchildren();i++)
      {
       if(e.subtree(i).switchOff(f)!=null)
       {
         E=e.subtree(i).switchOff(f);
       }
     }
     }
     //System.out.println("hemant");
   return E;

}*/

public void Update(Exchange p,int id)
{
    p=p.parent;
    if(p==null)
    {
      return;
    }
  else
  {
    //System.out.println("hj");
    
   p.m.Insert(id);
    Update(p,id);
   }
 }
 public String performAction(String actionMessage){
  Scanner a =new Scanner(actionMessage);
  String name=a.next();
  
  String d="";
  if(name.equals("addExchange"))
  {
    int A =a.nextInt();
    int B =a.nextInt();
   // this.root.id = A;
   // System.out.println();
   // System.out.println(this.find(A));
    if(this.find(A)==null)
    {
      d=d+actionMessage+": Error-Exchange with identifier "+A+" not found";
    }
    else{
      //this.addExchange(find(A),B);
      Exchange b=new Exchange(B);
      b.parent=find(A);
     // System.out.println(this.find(A).id);
    this.find(A).children.add(b);
    //  System.out.println(this.find(A).child(0).id);
     // System.out.println(this.find(A).children.size());
     
     // System.out.println(find(0));
     // System.out.println(find(1));
    }

  }
  if(name.equals("queryNthChild"))
  {
    int A =a.nextInt();
    int B =a.nextInt();
    if(this.find(A).children.get(B)==null)
    {
      d=d+actionMessage+":Error - No "+ B +"child of Exchange "+A;
    }
    else{
     d=d+actionMessage+": "+ find(A).children.get(B).id;
    }
  }
  if(name.equals("queryMobilePhoneSet"))
  { 
    String t="";
    d=d+actionMessage+": ";
     int A =a.nextInt();
     for(int i=0;i<this.find(A).m.size();i++){
      if(this.find(A).m.get(i).status==true){
        t=t+this.find(A).m.get(i).id+", ";
      } 
    }
      if(t!=""){
        d=d+t.substring(0,t.length()-2);
      }
    
  }
  if(name.equals("switchOnMobile"))
  {
    int A =a.nextInt();
    int B =a.nextInt();
    if(this.find(B)==null)
       {
      d=d+actionMessage+": "+"Error- No exchange with identifier "+ B;
    }
   else{
      MobilePhone k=new MobilePhone(A);
      k.status=true;
      /*if(find(B).m.findphone(k)==0)
      {
        this.switchOn(A, find(B));
      }*/
     // else

      this.switchOn(A, find(B));
    }
  }
 if(name.equals("switchOffMobile"))
  {
    int A =a.nextInt();
    MobilePhone f=new MobilePhone(A);
    if(root.m.findphone(f)!=null){
    this.switchOff(f);
  }
  else{
    d=d+actionMessage+": Error-No mobile phone with identifier "+A;
  }


  }
  if(name.equals("findPhone"))
  {
    int A =a.nextInt();
    MobilePhone f=new MobilePhone(A);
    if(findphone2(f)==null)
      {
        d=d+"queryFindPhone "+A+": Error - No mobile phone with identifier "+ A + " found in the network";
      }
      else
    d=d+"queryFindPhone "+A+": "+findphone2(f).id;
  }
  if(name.equals("lowestRouter"))
  {
    int A =a.nextInt();
    int B =a.nextInt();
    Exchange c=find(A);
    Exchange e=find(B);
    d=d+"queryLowestRouter " +A +" "+ B+": "+lowestRouter(c,e).id;
  }
  if(name.equals("findCallPath"))
  {
    int A =a.nextInt();
    int B =a.nextInt();
    MobilePhone f=new MobilePhone(A);
    MobilePhone k=new MobilePhone(B);
    ExchangeList q=new ExchangeList();
   // ExchangeList q=routeCall(f,k);
    String t="";
    if(this.findphone2(f)==null)
    {
      //System.out.println("hemant");

      d=d+"queryFindCallPath "+A+" "+B+": Error - Mobile phone with identifier "+ A+ " is currently switched off";
    }
    if(this.findphone2(k)==null)
    {
      //System.out.println("hemant");
       d=d+"queryFindCallPath "+A+" "+B+": Error - Mobile phone with identifier "+ B+ " is currently switched off";
    }
    if(this.findphone2(f)!=null&&this.findphone2(k)!=null)
    {
      q=routeCall(f,k);
    d=d+"queryFindCallPath "+A +" "+ B+": ";
    while(q.child!=null)
    {
      t=t+q.child.obj.id+", ";
      q.child=q.child.next;
    }
    //t=t+q.child.obj.id+", ";
    //System.out.println(q.child.next);
     if(t!=""){
        d=d+t.substring(0,t.length()-2);
      }
    }
  }
  if(name.equals("movePhone"))
  {
     int A =a.nextInt();
    int B =a.nextInt();
    Exchange c=find(B);
    MobilePhone f=new MobilePhone(A);
    movePhone(f,c);
  }
  return d;
}
}

