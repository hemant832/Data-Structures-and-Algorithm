public class AVLTree<T>{
	 TreeNode<T> root=new TreeNode<>();
	public int getheight(TreeNode<T> t) 
	{
    if (t == null) 
        return 0; 
    return t.height; 
	}
	public int max(int a, int b) 
	{ 
     if(a>b)
     return a;
     else
     return b; 
	}
	public TreeNode<T> rightRotate(TreeNode<T> y) { 
        TreeNode<T> x = y.leftchild; 
        TreeNode<T> z = x.rightchild;
        x.rightchild = y; 
        y.leftchild = z;  
        y.height = max(getheight(y.leftchild), getheight(y.rightchild)) + 1; 
        x.height = max(getheight(x.leftchild), getheight(x.rightchild)) + 1; 
        return x; 
    } 
    public TreeNode<T> leftRotate(TreeNode<T> x) { 
        TreeNode<T> y = x.rightchild; 
        TreeNode<T> z = y.leftchild; 
        y.leftchild = x; 
        x.rightchild = z; 
        x.height = max(getheight(x.leftchild), getheight(x.rightchild)) + 1; 
        y.height = max(getheight(y.leftchild), getheight(y.rightchild)) + 1;  
        return y; 
    } 
    public int htdiffer(TreeNode<T> t) { 
        if (t == null) 
            return 0; 
  
        return getheight(t.leftchild) - getheight(t.rightchild); 
    }
      
   /* TreeNode<Position> root=new TreeNode<>();
    //Node<Position> temp=new Node<>();
   // temp=l.head;l
     Node<Position> temp ;
     temp = l.head;
    /*while(true)
    {
    	Position p=temp.data;
    	root=this.addnode(root,p);
    	temp=temp.next;
    	if(temp == null){
    		break;
    	}
    }*/
    
}