public class test{
	public static void main(String args[]){
		/*Myset a=new Myset();
		a.InsertNode(4);
		a.InsertNode(5);
		a.InsertNode(6);
		Myset b=new Myset();
		b.InsertNode(1);
		b.InsertNode(2);
		b.InsertNode(3);
		Myset c=new Myset();
		c=a.Union(b);
		//c=a.Intersection(b);

		while(c.head!=null)
		{
			System.out.println(c.head.data);
			c.head=c.head.next;
		}*/
		/*RoutingMapTree r=new RoutingMapTree();
		//Exchange e=r.root;
		System.out.println(r.root.children.size());
		r.addExchange(r.root,1);
		System.out.println("h");
		System.out.println(r.root.children.size());*/

		/*RoutingMapTree r=new RoutingMapTree();
		Exchange b=new Exchange(1);
		r.root.children.add(b);
		Exchange c=new Exchange(2);
		r.root.children.add(c);
		Exchange d=new Exchange(3);
		r.root.children.add(d);
		Exchange e=new Exchange(4);
		System.out.println(r.root.child(0).id);*/
		//r.find(1).children.add(e);
		//System.out.println(r.find(1).children.size());


		/*Exchange a= r.find(1);
		System.out.println(r.root.children.size());
		System.out.println(r.find(1));
		ExchangeList e=new ExchangeList();
		Exchange b=new Exchange(1);
		e.add(b);
		System.out.println(e.size());*/
		RoutingMapTree t = new RoutingMapTree();
		t.performAction("addExchange 0 1");
		t.performAction("addExchange 0 2");
		t.performAction("addExchange 0 3");
		t.performAction("addExchange 1 4");
		t.performAction("addExchange 1 5");
		t.performAction("addExchange 2 6");
		t.performAction("addExchange 2 7");
		t.performAction("addExchange 2 8");
		t.performAction("addExchange 3 9");
		t.performAction("queryNthChild 0 0");
		t.performAction("queryNthChild 0 2");
        t.performAction("switchOnMobile 989 4");
         t.performAction("switchOnMobile 876 4");
         //t.performAction("queryMobilePhoneSet 4");
        t.performAction("queryMobilePhoneSet 1");
         t.performAction("switchOnMobile 656 5");
         t.performAction("switchOnMobile 54 5");
         t.performAction("queryMobilePhoneSet 1");
        // t.performAction("switchOffMobile 656");
      //  t.performAction("queryMobilePhoneSet 1");
       
       // t.performAction("queryMobilePhoneSet 5");
        /* MobilePhone f=new MobilePhone(656);
         t.root.m.findphone(f).status=false;
         t.performAction("queryMobilePhoneSet 0");*/
        /*int z=t.root.m.findphone(f);
        System.out.println(z);*/
        //t.root.m.print();
       // t.find(0).m.print();
        //System.out.println(t.find(0).parent);

}
}