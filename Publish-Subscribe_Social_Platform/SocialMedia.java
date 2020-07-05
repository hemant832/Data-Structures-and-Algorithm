import java.util.*;
public class SocialMedia{
	MySet<User> user=new MySet<>();
	public User finduser(int id)
	{
		Node<User> temp=this.user.head;
		while(temp!=null)
		{
			if(temp.data.id==id)
				return temp.data;
			temp=temp.next;
		}
		return null;
	}
		public Text findtext(int id)
	{
		
		Node<User> temp=this.user.head;
		while(temp!=null)
			{
				Node<Text> temp2=temp.data.text.head;
				while(temp2!=null)
				{
				if(temp2.data.id==id)
				{
					return temp2.data;
				}
				temp2=temp2.next;
			   }
			   temp=temp.next;
			}
			return null;

	}
	public int max(int a,int b)
		{
			if(a>=b)
				return a;
			else{
				return b;
		}
			}
	public void NewPost(int t,int uid,String text,int tid)
	{
		Text newtext=new Text();
		newtext.time=t;
		newtext.flag=0;
		newtext.text=text;
		newtext.id=tid;
		if(finduser(uid)!=null)
		{
			//System.out.println(finduser(uid).id+" ruh");
			newtext.user=finduser(uid);
			finduser(uid).text.Insert(newtext);
		}
		else{
				
			User u=new User();
			u.id=uid;
			newtext.user=u;
			u.text.Insert(newtext);
			this.user.Insert(u);
		}

	}
	public void Repost(int t,int uid,int ptid,int tid)
	{
		Text newtext=new Text();
		//System.out.println(findtext(ptid)+"new");
		if(findtext(ptid)==null)
			System.out.println("No text with ptid "+ptid);
		else{
		newtext.text=this.findtext(ptid).text;
		newtext.time=t;
		newtext.flag=1;
		newtext.id=tid;
		if(finduser(uid)!=null)
		{
			newtext.user=finduser(uid);
			finduser(uid).text.Insert(newtext);

		}
		else{
			User u=new User();
			u.id=uid;
			newtext.user=u;
			u.text.Insert(newtext);
			this.user.Insert(u);
		}
	}
}
	public void Reply(int t,int uid,int ptid,String text,int tid)
	{
		Text newtext=new Text();
		newtext.time=t;
		newtext.flag=2;
		newtext.id=tid;
		newtext.text=text;
		if(finduser(uid)!=null)
		{
			newtext.user=finduser(uid);
			finduser(uid).text.Insert(newtext);
		}
		else{
			User u=new User();
			u.id=uid;
			newtext.user=u;
			u.text.Insert(newtext);
			this.user.Insert(u);
		}
		this.findtext(ptid).replies.Insert(newtext);
	}
	public void performAction(String actionMessage)
	{
		Scanner a =new Scanner(actionMessage);
		String k=a.next();
		String[] t = k.split("[,()]+");
		if(t[0].equals("SUBSCRIBE"))
		{
			Subscription sub=new Subscription();
			sub.time=Integer.parseInt(t[1]);
			int uid=Integer.parseInt(t[2]);
			int pid=Integer.parseInt(t[3]);
			if(finduser(pid)!=null)
		{
			sub.user=finduser(pid);

		}
		else{
			User u=new User();
			u.id=pid;
			sub.user=u;
			this.user.Insert(u);
		}
			if(finduser(uid)!=null)
		{

			finduser(uid).following.Insert(sub);

		}
		else{
			User u=new User();
			u.id=uid;
			u.following.Insert(sub);
			this.user.Insert(u);
		}
		System.out.println(k);
		}
		if(t[0].equals("UNSUBSCRIBE"))
		{
					Subscription sub=new Subscription();
					int count=0;
			sub.time=Integer.parseInt(t[1]);
			int uid=Integer.parseInt(t[2]);
			int pid=Integer.parseInt(t[3]);
			if(finduser(pid)!=null&&finduser(uid)!=null)
			{
				Node<Subscription> temp=finduser(uid).following.head;
				if(temp==null)
				System.out.println("uid"+" "+uid +" has not subscribed to pid"+" "+pid);	
			else{
				while(temp!=null)
				{
					//System.out.println(temp.data.user.id+" following");
					if(temp.data.user.id==pid)
					{
						count=1;
						//System.out.println(temp.data.user.id+" delete");
						finduser(uid).following.Delete(temp.data);
					}

					temp=temp.next;
				}
				if(count==1)
				System.out.println(k);
			else{
				System.out.println("uid"+" "+uid +" has not subscribed to pid"+" "+pid);
			}
			}

			}
			else{
				System.out.println("uid"+" "+uid +" has not subscribed to pid"+" "+pid);
			}
		/*	if(finduser(pid)!=null)
		{
			sub.user=finduser(pid);

		}
		else{
			User u=new User();
			u.id=pid;
			sub.user=u;
			this.user.Insert(u);
		}
			if(finduser(uid)!=null)
		{

			finduser(uid).unfollowing.Insert(sub);

		}
		else{
			User u=new User();
			u.id=uid;
			u.unfollowing.Insert(sub);
			this.user.Insert(u);
		}*/
		
		}
		if(t[0].equals("PUBLISH"))
		{
			if(t[3].equals("NEW"))
			{
				//System.out.println(" new");
			int time=Integer.parseInt(t[1]);
			int uid=Integer.parseInt(t[2]);
			int tid=Integer.parseInt(t[5]);
				if(findtext(tid)==null)
			{
			this.NewPost(time,uid,t[4],tid);
		    System.out.println(k);
		   }
			else
			{
				System.out.println("Can't publish with tid"+" "+tid);
			}
			}
			if(t[3].equals("REPOST"))
			{
			int time=Integer.parseInt(t[1]);
			int uid=Integer.parseInt(t[2]);
			int ptid=Integer.parseInt(t[4]);
			int tid=Integer.parseInt(t[5]);
			if(findtext(tid)==null)
			{
			this.Repost(time,uid,ptid,tid);
		    System.out.println(k);
		   }
		    else
			  {
				System.out.println("Can't publish with tid"+" "+tid);
			  }
			}
			
			if(t[3].equals("REPLY"))
			{
		    int time=Integer.parseInt(t[1]);
			int uid=Integer.parseInt(t[2]);
			int ptid=Integer.parseInt(t[4]);
			int tid=Integer.parseInt(t[6]);
			if(findtext(tid)==null)
			{
			this.Reply(time,uid,ptid,t[5],tid);
		    System.out.println(k);
		   }
			else
			{
				System.out.println("Can't publish with tid"+" "+tid);
			}
			}
			
			
		}
		if(t[0].equals("READ"))
		{
			String b="";
			String d="";
			MySet<Text> set=new MySet<>();
			int uid=Integer.parseInt(t[2]);
			int to=Integer.parseInt(t[1]);
			if(finduser(uid)==null)
		  System.out.println("No user with uid"+" "+t[2]+" is present");
		else{
			Node<Subscription> temp=finduser(uid).following.head;
			//Node<Subscription> temp2=finduser(uid).unfollowing.head;
			while(temp!=null)
			{
				//System.out.println(finduser(1).text.head.data.text);
				//System.out.println(temp.data.user.id);
				Node<Text> h=temp.data.user.text.head;
				while(h!=null)
				{
					if(this.max(finduser(uid).lastseen,temp.data.time)<=h.data.time)
				set.Insert(h.data);
				 h=h.next;
				}
				temp=temp.next;

		}
			Node<Text> temp3=finduser(uid).text.head;
				while(temp3!=null)
			{
				Node<Text> temp4=temp3.data.replies.head;
				while(temp4!=null)
				{
				if(finduser(uid).lastseen<=temp4.data.time)
				set.Insert(temp4.data);
			   temp4=temp4.next;
			}
			temp3=temp3.next;
			}
				if(set.head==null)
				{
				System.out.println("no text available for uid "+uid);
			}
			else{
				MySet<SearchResult> s=new MySet<SearchResult>();
		while(set.head!=null)
		{
			//System.out.println(" yeah");
			if(set.head.data.time<to)
			{
				SearchResult sr=new SearchResult(set.head.data.text,set.head.data.time);
                s.Insert(sr);
			//d=d+set.head.data.text+",";
			System.out.println(set.head.data.text+" "+set.head.data.time);
		}
			set.head=set.head.next;
		}
		 MySort ms=new MySort();
             ArrayList<SearchResult> list=ms.sortThisList(s);
              for(int o=0;o<list.size();o++)
            {
               d=d+list.get(o).text+ ","; 
            }
		finduser(uid).lastseen=to;
		if(d.length()!=0)
		b=d.substring(0,d.length()-1);
		System.out.println(k+","+"["+b+"]");
	}
	}
}
}
}