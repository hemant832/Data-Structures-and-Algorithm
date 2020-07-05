import java.io.*;
import java.util.*;
import java.lang.Math;
public class PageEntry
{
	PageIndex p=new PageIndex();
	String a=""; 
	String b="";
	String word="";
	int i=1;
  int real=1;
	String pagename;

	//MyLinkedList<PageIndex> p=new MyLinkedList<>;
	PageEntry(String pageName)
	{
		this.pagename=pageName;
    try{
      BufferedReader objReader=new BufferedReader(new FileReader(pageName));
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
            Position r=new Position(this,real);
           this.p.addPositionForWordavl(word,r);
           this.p.addPositionForWord2(word,r);
 	    			//System.out.println("hemant");
 	    			//this.p.W.Insert(w);
 	    			this.p.addPositionForWord(word,z);
 	    			i=i+1;
            real=real+1;
 	    		}
 	    	}
	}catch(IOException e){
	e.printStackTrace();
}
}
public WordEntry getWordEntryofindex(int index,PageEntry p)
{
  Node<WordEntry> temp=p.p.W.head;

  while(temp!=null)
  {
   if(temp.data.find(temp.data.root,index)==true)
    return temp.data;
  temp=temp.next;
}
  return null;
}
public int numofphrase(String str[ ],InvertedPageIndex bucket)
{
    int numofphrase=0;
    WordEntry w=this.p.findwordentry(str[0]);
    int i=0;
    // WordEntry q=bucket.t.getWordEntry(str[1]);
    // int z=q.l.head.data.wordIndex;
     //System.out.println(z+" hemant8");
    Node<Position> temp=w.l2.head;
    int length=0;
    for(int b=0;str[b]!=null;b++)
    {
      length=length+1;
    }
   // System.out.println(this.pagename);
    //System.out.println(this.getWordEntryofindex(10,this).word+" wow");
    while(temp!=null)
    {
      //System.out.println((this.real-1)+" real");
      int k=temp.data.wordIndex;
     // System.out.println(k+" yeah3");
      if(this.getWordEntryofindex(k,this)!=null)
      //System.out.println(this.getWordEntryofindex(k,this).word+" yeah5");
       i=0;
      while(i!=length&&k!=(this.real-1))
      {
       // System.out.println("hemant4");
       // System.out.println(i+" hemant");
       // System.out.println(k+" hemant");
       // System.out.println(this.getWordEntryofindex(k+1,this).word+" yeah2");
        if(!(this.getWordEntryofindex(k+1,this).word.equals(str[i+1])))
        {
          i=i+1;
             break;
           }
            k=k+1;
             i=i+1;
        }
         if(i==length||k==(this.real-1))
      {
       // System.out.println("yeah");
        numofphrase=numofphrase+1;
      }
          temp=temp.next;
      }
     
    
    
    return numofphrase;

}
public float getRelevanceOfPage(String str[ ],boolean d,InvertedPageIndex bucket)
{
 // System.out.println("hemant3");
  if(d)
{
 float relevance=0;
 float tf=0;
 double itf=0;
 for(int i=0;str[i]!=null;i++)
  {
    WordEntry temp=bucket.t.getWordEntry(str[i]);
    while(temp!=null)
    {
      if(temp.l.head.data.p.pagename.equals(this.pagename))
      {
        tf=temp.getTermFrequency();
        //System.out.println("tf "+tf+" "+this.pagename);
      }
      temp=temp.bottom;
    }
   //System.out.println(tf+" hemant3");
    if(this.p.findwordentry(str[i])!=null)
    itf=Math.log((double)bucket.numberofpage/(double)bucket.numberofpagecontainword(str[i]));
    //System.out.println("itf "+itf+" "+this.pagename);
    relevance=relevance+(tf*(float)itf);
  }
  return relevance;
  }
  else{
    float itf=0;
    float tf=0;
    int u=0;
    int length=0;
     for(int i=0;str[i]!=null;i++)
    {
      length=length+1;
    }
      itf=(float)Math.log((float)bucket.numberofpage/(float)bucket.getPagesWhichContainPhrase(str).size());
  
    length=length-1;
   // System.out.println(length+" length");
   // System.out.println((this.real-1)+" total");
    u=this.numofphrase(str,bucket);
   // System.out.println(u);
    tf=(float)u/(float)(((float)this.real-1)-(float)length*u);
    //System.out.println("itf "+itf+" "+this.pagename);
   // System.out.println("tf "+tf+" "+this.pagename);
    return tf*itf;
  }
    
}

	public PageIndex getPageIndex()
	{
     return p;
	}
}
