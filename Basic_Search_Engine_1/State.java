package col106.assignment3.Election;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
public class State implements Comparable<State>{
	String name;
	public State(String name){
		this.name=name;
	}
	public int compareTo(State o){
		return name.compareTo(o.name);
	}
	BST<String,Constituency> bst=new BST<String,Constituency>();
	HashMap<String,Integer> partycount = new HashMap<String,Integer>();
	int totalvotes=0;
	public void insert(Candidate c){
		int cvotes = Integer.parseInt(c.votes);
		totalvotes+=cvotes;
		partycount.put(c.party,partycount.getOrDefault(c.party,0)+cvotes);
		Constituency temp=bst.findVal(c.constituency);
		if(temp==null){
			Constituency t= new Constituency(c.constituency);
			t.insert(c);
			bst.insert(c.constituency,t);
	    }
	    else{
	    	temp.insert(c);
	    }
	}
	public String leadingparty(){
		ArrayList<Constituency> temp = bst.values;
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		for(int i=0;i<temp.size();i++){
			String t = temp.get(i).winningparty();
			h.put(t,h.getOrDefault(t,0)+1);
		}
		int max = 0;
		String leadparty="";
		Iterator it = h.keySet().iterator();
		while(it.hasNext()){
			String k = (String)it.next();
			if(h.get(k)>max){
				leadparty=k;
				max=h.get(k);
			}
		}
		return leadparty;
	}
	public void cancelVoteConstituency(String c){
		Constituency ct = bst.findVal(c);
		totalvotes-=ct.totalvotes;
		Iterator it = partycount.keySet().iterator();
		while(it.hasNext()){
			String key = (String)(it.next());
			if(ct.partycount.get(key)!=null){
				partycount.put(key,partycount.get(key)-ct.partycount.get(key));
		    }
		}
		bst.delete(c);

	}
	public void update(String name,String candID,String votes,int oldvotes,String constituency,String party){
		Constituency c=bst.findVal(constituency);
		c.update(name,candID,votes,oldvotes,party);
		int v = Integer.parseInt(votes);
		partycount.put(party,partycount.getOrDefault(party,0)-oldvotes+v);
		totalvotes+=v-oldvotes;
	}
	public ArrayList<String> topKinConstituency(String constituency,String k){
		Constituency ct = bst.findVal(constituency);
		return ct.topKinConstituency(Integer.parseInt(k));
	}
	public float voteshare(String party){
		return ((float)partycount.get(party)/(float)totalvotes)*100;
	}
}