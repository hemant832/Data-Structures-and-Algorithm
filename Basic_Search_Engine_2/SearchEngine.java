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
            String d="";
            String t="";
            int i=0;
           // String[] array;
            String[] array=new String[20];
            for(i=0;i<20&&a.hasNext();i++)
            {
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
                array[i]=y;
            }
           // System.out.println(j+" gyte");
            MySet<PageEntry> temp=new MySet<>();
            temp=bucket.getPagesWhichContainWord(array[0]);
            MySet<SearchResult> s=new MySet<SearchResult>();

            while(temp.head!=null)
            {
                //System.out.println(temp.head.data.pagename);
               // System.out.println(temp.head.data.pagename+" "+temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                SearchResult sr=new SearchResult(temp.head.data,temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                s.Insert(sr);
            // System.out.println(temp.head.data.getRelevanceOfPage(array,this.bucket));
             temp.head=temp.head.next;
            }
            MySort ms=new MySort();
             ArrayList<SearchResult> list=ms.sortThisList(s);
            for(int o=0;o<list.size();o++)
            {
               d=d+list.get(o).p.pagename+ " ,"; 
            }
            if(d.length()!=0)
            {
             t=t+d.substring(0,d.length()-1);
             System.out.println(t);
            }
            


        	//System.out.println("hemant");
            /* String x=a.next();
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
        }*/
        }
        if(name.equals("queryFindPositionsOfWordInAPage"))
        {
             String x=a.next();
             String z=x.toLowerCase();
              if(z.equals("structures"))
                {
                z="structure";
                }
                if(z.equals("stacks"))
                {
                z="stack";
                }
                if(z.equals("applications"))
                {
                z="application";
                }
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
        if(name.equals("queryFindPagesWhichContainAllWords"))
        {
            //System.out.println("hemant");
            String d="";
            String t="";
            int j=0;
            int i=0;
           // String[] array;
            String[] array=new String[20];
            for(i=0;i<20&&a.hasNext();i++)
            {
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
                array[i]=y;
            }
            j=i;
           // System.out.println(j+" gyte");
            MySet<PageEntry> temp=this.bucket.getPagesWhichContainWord(array[0]);
            for(i=1;i<j;i++)
            {
                temp=temp.Intersection(this.bucket.getPagesWhichContainWord(array[i]));
            }
            MySet<SearchResult> s=new MySet<SearchResult>();

            while(temp.head!=null)
            {
                //System.out.println(temp.head.data.pagename);
               // System.out.println(temp.head.data.pagename+" "+temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                SearchResult sr=new SearchResult(temp.head.data,temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                s.Insert(sr);
            // System.out.println(temp.head.data.getRelevanceOfPage(array,this.bucket));
             temp.head=temp.head.next;
            }
            MySort ms=new MySort();
             ArrayList<SearchResult> list=ms.sortThisList(s);
            for(int o=0;o<list.size();o++)
            {
               d=d+list.get(o).p.pagename+ ","; 
            }
            t=t+d.substring(0,d.length()-1);
            System.out.println(t);


        }
        if(name.equals("queryFindPagesWhichContainAnyOfTheseWords"))
        {
             String d="";
            String t="";
           int j=0;
           int i=0;
            //String[] array;
            String[] array=new String[20];
            for(i=0;i<20&&a.hasNext();i++)
            {
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
                array[i]=y;
            }
            i=j;
            MySet<PageEntry> temp=this.bucket.getPagesWhichContainWord(array[0]);
            for(i=1;i<j;i++)
            {
                temp=temp.Union(this.bucket.getPagesWhichContainWord(array[i]));
            }
              MySet<SearchResult> s=new MySet<SearchResult>();

            while(temp.head!=null)
            {
               // System.out.println(temp.head.data.pagename+" "+temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                //System.out.println(temp.head.data.pagename);
                SearchResult sr=new SearchResult(temp.head.data,temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                s.Insert(sr);
            // System.out.println(temp.head.data.getRelevanceOfPage(array,this.bucket));
             temp.head=temp.head.next;
            }
            MySort ms=new MySort();
             ArrayList<SearchResult> list=ms.sortThisList(s);
            for(int o=0;o<list.size();o++)
            {
               d=d+list.get(o).p.pagename+ ","; 
            }
            t=t+d.substring(0,d.length()-1);
            System.out.println(t);
        } 
        if(name.equals("queryFindPagesWhichContainPhrase"))
        {
             String d="";
            String t="";
             String[] array=new String[20];
            for(int i=0;i<20&&a.hasNext();i++)
            {
                array[i]=a.next();
            }
            MySet<PageEntry> temp=this.bucket.getPagesWhichContainPhrase(array);
            if(temp.head==null)
            {
               System.out.println("No webpage contains the given phrase");
            }
               MySet<SearchResult> s=new MySet<SearchResult>();

            while(temp.head!=null)
            {
               // System.out.println(temp.head.data.pagename+" "+temp.head.data.getRelevanceOfPage(array,true,this.bucket));
                //System.out.println(temp.head.data.pagename);
                SearchResult sr=new SearchResult(temp.head.data,temp.head.data.getRelevanceOfPage(array,false,this.bucket));
                s.Insert(sr);
            // System.out.println(temp.head.data.getRelevanceOfPage(array,this.bucket));
             temp.head=temp.head.next;
            }
            MySort ms=new MySort();
             ArrayList<SearchResult> list=ms.sortThisList(s);
            for(int o=0;o<list.size();o++)
            {
               d=d+list.get(o).p.pagename+ ","; 
            }
            t=t+d.substring(0,d.length());
            System.out.println(t);
         /*   while(temp.head!=null)
            {
                System.out.println(temp.head.data.getRelevanceOfPage(array,false,this.bucket));
                temp.head=temp.head.next;
            }*/
        }
        }


	}

	
