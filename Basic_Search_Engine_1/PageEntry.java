import java.io.*;
import java.util.*;
public class PageEntry
{
	PageIndex p=new PageIndex();
	String a=""; 
	String b="";
	String word="";
	int i=1;
	String pagename;

	//MyLinkedList<PageIndex> p=new MyLinkedList<>;
	PageEntry(String pageName)
	{
		this.pagename=pageName;
    try{
      BufferedReader objReader=new BufferedReader(new FileReader(pageName+".txt"));
      a=objReader.readLine();
      while(a!=null)
      {
      	b=b+" "+a;
        a=objReader.readLine();
      }  
      b=b.toLowerCase();
      b=b.replaceAll("\\{", " ");
      b=b.replaceAll("\\}", " ");
      b=b.replaceAll("\\[", " ");
      b=b.replaceAll("\\]", " ");
      b=b.replaceAll("\\<", " ");
      b=b.replaceAll("\\>", " ");
      b=b.replaceAll("=", " ");
      b=b.replaceAll("\\(", " ");
      b=b.replaceAll("\\)", " ");
      b=b.replaceAll("\\.", " ");
      b=b.replaceAll("\\,", " ");
      b=b.replaceAll("\\;", " ");
      b=b.replaceAll("\\'", " ");
      b=b.replaceAll("\"", " ");
      b=b.replace("?", " ");
      b=b.replaceAll("#", " ");
      b=b.replaceAll("!", " ");
      b=b.replaceAll("-", " ");
      b=b.replaceAll(":", " ");
 	    Scanner s=new Scanner(b);
 	    while(s.hasNext())
 	    	{
 	    		String k=s.next();
 	    		if(k.equals("structures"))
 	    		{
 				k="structure";
 	    		}
 	    		if(k.equals("stacks"))
 	    		{
 				k="stack";
 	    		}
 	    		if(k.equals("applications"))
 	    		{
 				k="application";
 	    		}
 	    		word=k;
 	    		if(word.equals("is")||word.equals("for")||word.equals("of")||word.equals("the")||word.equals("a")||word.equals("an")||word.equals("they")||word.equals("this")||word.equals("these")||word.equals("are")||word.equals("was")||word.equals("or")||word.equals("does")||word.equals("will")||word.equals("whose")||word.equals("and"))
 	    			i=i+1;
 	    		else
 	    		{
 	    	
 	    			Position z=new Position(this,i);
 	    			//System.out.println("hemant");
 	    			//this.p.W.Insert(w);
 	    			this.p.addPositionForWord(word,z);
 	    			i=i+1;
 	    		}
 	    	}
	}catch(IOException e){
	e.printStackTrace();
}
}

	PageIndex getPageIndex()
	{
     return p;
	}
}
