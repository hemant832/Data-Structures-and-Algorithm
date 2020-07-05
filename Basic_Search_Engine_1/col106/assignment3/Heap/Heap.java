package col106.assignment3.Heap;
import java.util.ArrayList;
public class Heap<T extends Comparable<T>,E extends Comparable<E>> implements HeapInterface <T, E>{
 	public class Node { 
        T key; 
        E value;
        Node left, right;
        public Node(T k,E l) {
            value = l; 
            key = k; 
            left = right = null; 
        } 
    } 
    // public static void main() {
    //     HeapDriverCode HDC = new HeapDriverCode();
    //     System.setOut(HDC.fileout());
    // }
    public ArrayList<Node> h;
    public int size;
    public int maxsize;
     public Heap() 
    { 
        this.size = 0; 
        h = new ArrayList<Node>(1000);
        h.add(null);
    } 
    public int parent(int pos){
        return pos/2;
    }
    public void swap(int a,int b){
        Node temp = h.get(a);
        h.set(a,h.get(b)) ;
        h.set(b,temp);
    }
     public void printHeap() 
    { 
        for(int i=1;i<=size;i++){
            System.out.println( h.get(i).key+", "+h.get(i).value );
        }
    }

     public void maxHeapify(int pos) 
    { 
        if (2*pos>size)
            return; 
        else if(2*pos+1>size){
            if(h.get(pos).value.compareTo((h.get(2*pos).value))<0){
                swap(pos, 2*pos); 
                maxHeapify(2*pos);                
            }
        }
        else{
            if ((h.get(pos).value.compareTo((h.get(2*pos).value))<0) ||  
                (h.get(pos).value.compareTo((h.get(2*pos+1).value))<0)) { 

                if ((h.get(2*pos).value).compareTo(h.get(2*pos+1).value)>0) {
                    swap(pos, 2*pos); 
                    maxHeapify(2*pos); 
                } 
                else { 
                    swap(pos, 2*pos+1); 
                    maxHeapify(2*pos+1); 
                } 
            } 
        }
    } 

    public void insert(T key, E value) 
    { 
        size++;
        if(h.size()<=size){
           h.add(new Node(key,value));
        }
        else
            h.set(size, new Node(key,value));
        int current = size; 
            while (current>1&&h.get(current).value.compareTo(h.get(parent(current)).value) >0 ) { 
                swap(current, parent(current)); 
                current = parent(current); 
            } 
        
    }
     public E extractMax() 
    { 
        if(size==0) return null;
        Node popped = h.get(1);
        if(size>1) {
        h.set(1,h.get(size--));
        maxHeapify(1);
        }
        else size--; 
        return popped.value; 
    } 
       public  Node extractMaxNode() 
    { 
        if(size==0) return null;
        Node popped = h.get(1);
        if(size>1) {
        h.set(1,h.get(size--));
        maxHeapify(1);
        }
        else size--; 
        return popped; 
    } 
    public ArrayList<E> sort(){
        ArrayList<Node> a=new ArrayList<Node>();
        ArrayList<E> b=new ArrayList<E>();
        int s = size;
        for(int i=1;i<=s;i++){
            Node tt = this.extractMaxNode();
            a.add(tt);
        }
        for(int i=0;i<a.size();i++){
            b.add(a.get(a.size()-i-1).value);
        }
          for(int i=0;i<a.size();i++){
            this.insert(a.get(i).key,a.get(i).value);
        }
        return b;
    }
    public void delete(T key){
        for(int i=1;i<=size;i++){
            if(h.get(i).key.compareTo(key)==0){
                h.set(i,h.get(size--));
                int current = i; 
                while (current>1&&h.get(current).value.compareTo(h.get(parent(current)).value) >0 ) { 
                    swap(current, parent(current)); 
                    current = parent(current); 
                }                 
                 maxHeapify(i);
                 break; 
             }
        }
    }
    public void increaseKey(T key,E value){
        for(int i=1;i<=size;i++){
            if(h.get(i).key.compareTo(key)==0){
                h.get(i).value=value;
                int current = i; 
                while (current>1&&h.get(current).value.compareTo(h.get(parent(current)).value) >0 ) { 
                    swap(current, parent(current)); 
                    current = parent(current); 
                }                 
                 maxHeapify(i);
                 break; 
             }
        }  
  }
}
