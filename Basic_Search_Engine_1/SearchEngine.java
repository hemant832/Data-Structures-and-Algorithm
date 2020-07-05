import java.io.*;
import java.util.*;
public class SearchEngine
{
	InvertedPageIndex bucket;
	SearchEngine()
	{
	  bucket=new InvertedPageIndex();	
	}
	public void performAction(String actionMessage)
	{
		Scanner a =new Scanner(actionMessage);
        String name=a.next();
        if(name.equals("addPage"))
        {
        	String x=a.next();
        	PageEntry p=new PageEntry(x);
        	// System.out.println(p.pagename+" enters");
        	// System.out.println(" hemant3");
            //System.out.println(p.pagename);
            //System.out.println(p.p.W.head.next.data.word);
           //System.out.println(p.b);
        	//System.out.println(bucket);
        	this.bucket.addPage(p);
        	//System.out.println("hemant2");

        }
        /*if(name.equals("print"))
        {
        	System.out.println(this.bucket.t.hash.head.next.data.bottom.l.head.data.p.pagename);
        }*/
        if(name.equals("queryFindPagesWhichContainWord"))
        {
        	//System.out.println("hemant");
             String x=a.next();
             String y=x.toLowerCase();
             if(y.equals("structures"))
 	    		{
 				y="structure";
 	    		}
 	    		if(y.equals("stacks"))
 	    		{
 				y="stack";
 	    		}
 	    		if(y.equals("applications"))
 	    		{
 				y="application";
 	    		}
             MySet<PageEntry> c=new MySet<>();
             String d="";
             String t="";
        	c=bucket.getPagesWhichContainWord(y);
        	if(c.head!=null)
        	{
        	while(c.head!=null)
        	{
        		//System.out.println(c.head.data.pagename+",");
        		d=d+c.head.data.pagename+",";
        		//System.out.println(c.head.data.pagename+" hemant");
        		c.head=c.head.next;
        	}
        	t=t+d.substring(0,d.length()-1);
        	System.out.println(t);
        }
        }
        if(name.equals("queryFindPositionsOfWordInAPage"))
        {
             String x=a.next();
             String z=x.toLowerCase();
             String y=a.next();
             String d="";
             String t="";
             Node<Position> i;
             i=null;
            // System.out.println(y+"  hemant");
        	WordEntry temp=bucket.t.getWordEntry(z);
        	if(temp!=null)
        	{
        	//System.out.println(temp.word+" got");
        		 
        	 i=temp.l.head;
            // System.out.println(temp.l.head+" got");
         }

        		/*Node<WordEntry> temp2;
	             temp2=this.bucket.t.hash.head;
	             while(temp2!=null)
	             {
	             	if(temp2.data.l.head.data.p.pagename.equals(y));
	             	{
	             		break;
	             	}
	             	temp2=temp2.next;
	             }
	             if(temp2==null)
	             {
	             	System.out.print("no webpage"+y+"found");
	             }*/

        	if(temp==null)
        	{
        		//System.out.println("word"+x+"is not present in SearchEngine");
        		System.out.println("web page "+y+" does not contain word "+x);
        	}
        	if(temp!=null)
           {
           	while(temp!=null)
           	{
           		//System.out.println("hemant3");
           	//System.out.println(temp.l.head.data.p.pagename+" hemant");
           //	System.out.println(y);
        	if(y.equals(temp.l.head.data.p.pagename))
        	{
              Node<Position> q;
              q=temp.l.head;
        	 // System.out.println("hemant3");	
        		while(temp.l.head!=null)
        	{
       		d=d+temp.l.head.data.wordIndex+",";
        	temp.l.head=temp.l.head.next;
        	}
        	t=t+d.substring(0,d.length()-1);
        	System.out.println(t);
        	temp.l.head=q;
        	}	
        temp=temp.bottom;
        }
      /*  WordEntry temp2=bucket.t.getWordEntry(z);

        if(temp!=null&&temp.l.head==null)
        {

        //bucket.t.getWordEntry(z).l.head=i;
        
        while(temp2==temp)
        {
        	temp2=temp2.bottom;   
        }
        temp.l.head=temp2.l.head;

        }*/
    }
        else{

        	System.out.println("word "+x+" is not found in web page "+y);
        	}
        }
	}

	
}