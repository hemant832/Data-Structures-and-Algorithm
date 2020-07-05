public class WordEntry
{
	String word;
	//int index;
    //PageEntry p;
    MyLinkedList<Position> l=new MyLinkedList<>();
    TreeNode<Position> root;
    MyLinkedList<Position> l2=new MyLinkedList<>();
    WordEntry bottom;

	WordEntry(String word)
	{
      this.word=word;
	}
	public void addPosition(Position position)
	{
		this.l.Insert(position);
      //this.index=position.wordIndex;
      //this.p=position.p;
	}
	public void addPosition2(Position position)
	{
		this.l2.Insert(position);
      //this.index=position.wordIndex;
      //this.p=position.p;
	}

	
	public  boolean find(TreeNode<Position> root, int index) {
		Boolean temp1=false;
		Boolean temp2=false;
		
		if (root.data != null) 
		{
			if (root.data.wordIndex <index)
		    {
		    	//System.out.println(root.rightchild.data.wordIndex+" bh");
		    	//System.out.println(this.word+" hemant3");
		    	if(root.rightchild!=null)
		    	temp1=find(root.rightchild,index);
			}
			 else if(root.data.wordIndex >index)
			 {
			 	if(root.leftchild!=null)
			   temp2=find(root.leftchild,index);;
			}
			else{
				//System.out.println(" wipee");
				return true;
			}
			if(temp1||temp2)
				return true;

		}
		return false;
}

		 public TreeNode<Position> addnode(TreeNode<Position> root,Position p)
    {
    	//System.out.println(root.data+" "+this.word);
    	if(root==null)
    	{
    		TreeNode<Position> r=new TreeNode<>();
    		r.data=p;
    		root=r;
    		//System.out.println(root.data.wordIndex+" yeah"+this.word);
    		//System.out.println(root.data.wordIndex+" hemant3 "+this.word);
    		return root;
    	}
    	//System.out.println(root.data.wordIndex+" hemant4 "+this.word);
    	if(p.wordIndex>root.data.wordIndex)
    	{
    		//System.out.println(" what");
    		/*TreeNode<Position> k=new TreeNode<>();
    		root.rightchild=k;*/
    		root.rightchild=addnode(root.rightchild,p);
    		//System.out.println(root.rightchild.data.wordIndex+" yeah "+this.word);
    	}
    	if(p.wordIndex<root.data.wordIndex)
    	{
    		/*TreeNode<Position> m=new TreeNode<>();
    		root.leftchild=m;*/
    		root.leftchild=addnode(root.leftchild,p);
    	}
    	root.height = 1 + root.max(root.getheight(root.leftchild), 
                              root.getheight(root.rightchild)); 
    	int balance=root.htdiffer(root);
    	  if (balance > 1 && p.wordIndex<root.data.wordIndex) 
            return root.rightRotate(root);  
        if (balance < -1 && p.wordIndex>root.data.wordIndex) 
            return root.leftRotate(root); 
        if (balance > 1 && p.wordIndex>root.data.wordIndex) { 
            root.leftchild = root.leftRotate(root.leftchild); 
            return root.rightRotate(root); 
        }
        if (balance < -1 && p.wordIndex<root.data.wordIndex) { 
            root.rightchild = root.rightRotate(root.rightchild); 
            return root.leftRotate(root); 
        }
        return root; 
	    }
		public void addPositionavl(Position position)
	{
		this.root=this.addnode(this.root,position);	
      //this.index=position.wordIndex;
      //this.p=position.p;

	}
	/*public  boolean find(TreeNode<Position> root, int index) {
		if (root != null) 
		{
			if (root.data.wordIndex == index)
		    {
				return true;
			}
			 else
			 {
			//return find(root.leftchild, index) || find(root.rightchild, index);
			 	find(root.leftchild, index);
			    find(root.rightchild, index);	    
			}
		}
		return false;
}*/
	public void addPositions(MyLinkedList<Position> positions)
	{
		//Node<Position> temp=l.head;
      while(positions.head!=null)
      {
      	/*this.l.temp.addPosition(positions.head);
      	temp=temp.next;*/
      	this.l.Insert(positions.head.data);
      	positions.head=positions.head.next;

      }
	}
	 
	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
     return l;
	}
	public float getTermFrequency()
	{
		int j=0;
		float gtf;
		Node<Position> temp=this.l.head;
		while(temp!=null)
		{
			j=j+1;
			temp=temp.next;
		}

		gtf=(float)j/(float)(this.l.head.data.p.real-1);
		return gtf;
	}
}




