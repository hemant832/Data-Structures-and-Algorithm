package col106.assignment3.BST;
import java.util.ArrayList;
public class BST<T extends Comparable<T>,E extends Comparable<E>> implements BSTInterface<T, E> { 
   public class Node{ 
        T key; 
        E value;
        Node left, right;


        public Node(T k,E l) {
            value = l; 
            key = k; 
            left = right = null; 
        } 
    } 

    public static void main() {
        BSTDriverCode BDC = new BSTDriverCode();
        System.setOut(BDC.fileout());
    }
    public Node root;
    public ArrayList<T> keys = new ArrayList<T>();
    public ArrayList<E> values = new ArrayList<E>();

    public E findVal(T key){
    	if(this.keys.contains(key))
    	return this.values.get(this.keys.indexOf(key));
        else
        	return null;
    }

    public void insert(T key , E value) {
    	keys.add(key);
    	values.add(value);
    	if(root == null){
    		this.root = new Node(key,value);
    	}
    	else{
    		Node r = this.root;
    		while(r != null){
    			if(value.compareTo(r.value) < 0){
    				if(r.left == null){
   					Node r1 = new Node(key,value);
   						r.left = r1;
   						break;
    				}
    				r = r.left;
    			}
    			else{
    				if(r.right == null){
   						Node r1 = new Node(key,value);
   						r.right = r1;
   						break;
    				}
    				r = r.right;
    			}
    		}
    	}
    } 
    public void update(T key,E value){
    	delete(key);
    	insert(key,value);
    }
 	public void delete(T key){
 		if(this.root.key==key){
 			this.root = deleterootsubtree(this.root);
   				keys.remove(0);
            		values.remove(0);
                    // System.out.println("hi1");
       			     return;
 		}
 		else{
			Node r = this.root;
	 		E value = findVal(key);	
 			for(int i=0;i<keys.size();i++){
        		if(keys.get(i).compareTo(key)==0){
        			keys.remove(i);
        			values.remove(i);
        			break;
        		}
    	   }
           // System.out.println("dd");
	 		Node prev=null ;   
	 		boolean d = false;	
			while(r!=null){
				if(value.compareTo(r.value) == 0){
					while(r!=null&&key.compareTo(r.key)!=0&&value.compareTo(r.value) == 0){
						prev = r;
                        if(r==null) break;
						r = r.right;
					}
                    Node upd=null;
                    if(r!=null)
					upd = deleterootsubtree(r);
                    if(prev!=null){
    					if(d) prev.right= upd;
    					else prev.left = upd;
                    }
					break; 
				}
				else if(value.compareTo(r.value) < 0){
					prev = r;
					r = r.left;
					d = false;
				}
				else{
					prev = r;
					r = r.right;
					d = true;
				}
			}
            // System.out.println("dd");
		}
 	}

 	public Node deleterootsubtree(Node r){
 		if(r.left==null){
 			if(r.right==null) return null;
 			else return r.right;
 		}
 		else{
 			if(r.right==null) return r.left;
 			else{
 				Node temp = r.right;
 				if(temp.left==null){
 					temp.left = r.left;
 					return temp;
 				}
 				while(temp.left.left!=null){
 					temp=temp.left;
 				}
 				Node ans = new Node(temp.left.key,temp.left.value);
 				ans.left = r.left;
 				ans.right = r.right;
 				Node upd = deleterootsubtree(temp.left);
 				temp.left = upd;
 				return ans;
 			}
 		}
 	}
    public void printBST(){
    	ArrayList<Node> temp=new ArrayList<Node>();
    	temp.add(this.root);
    	int t=0;
    	while(temp.size()!=t){
    		Node r=temp.get(t);
    		System.out.println(r.key+", "+r.value);
    		t++;
    		if(r.left!=null)
    			temp.add(r.left);
    		if(r.right!=null)
    			temp.add(r.right);
    	}
    }
    public ArrayList<E> printSpecialClass(){
        ArrayList<E> ans = new ArrayList<E>();
        ArrayList<Node> temp=new ArrayList<Node>();
        temp.add(this.root);
        int t=0;
        // System.out.println("My size :"+values.size());
        while(temp.size()!=t){
            Node r=temp.get(t);
            ans.add(r.value);
            t++;
            if(r.left!=null)
                temp.add(r.left);
            if(r.right!=null)
                temp.add(r.right);
        }
        return ans;        
    }
}