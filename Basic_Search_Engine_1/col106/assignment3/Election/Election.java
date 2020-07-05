package col106.assignment3.Election;
import col106.assignment3.BST.BST;
import col106.assignment3.Heap.Heap; 
// import col106.assignment3.Election.Candidate;
// import col106.assignment3.Election.State;
// import col106.assignment3.Election.Constituency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Election{
		BST<String,State> bst=new BST<String,State>();
	BST<String,Candidate> ans=new BST<String,Candidate>();
	HashMap<String,Candidate> candidatemap = new HashMap<String,Candidate>();
	HashMap<String,String> constituencymap = new HashMap<String,String>();
	HashMap<String,Heap<String,String>> cc = new HashMap<String,Heap<String,String>>(); 
	public void insert(String name,String candID,String state,String district,String constituency,String party,String votes){
		Heap<String,String> ttemp = cc.getOrDefault(constituency,new Heap<String,String>());
		ttemp.insert(candID,candID);
		cc.put(constituency,ttemp);
		ans.insert(candID,new Candidate(name,candID,state,district,constituency,party,votes));
		Candidate c = new Candidate(name,candID,state,district,constituency,party,votes);
		candidatemap.put(c.candID,c);
		State temp=bst.findVal(c.state);
		constituencymap.put(c.constituency,c.state);
		if(temp==null){
			State t= new State(c.state);
			t.insert(c);
			bst.insert(c.state,t);
	    }
	    else{
	    	temp.insert(c);
	    }
	}
	public void leadingPartyOverall(){
		HashMap<String,Integer> pt=new HashMap<String,Integer>();
		Iterator it = candidatemap.keySet().iterator();
		while(it.hasNext()){
			String key = (String)(it.next());
			//System.out.println(pt+"before"+candidatemap.get(key).party+" "+Integer.parseInt(candidatemap.get(key).votes));
			//String pname = candidatemap.get(key).party;
			pt.put(candidatemap.get(key).party,pt.getOrDefault(candidatemap.get(key).party,0)+Integer.parseInt(candidatemap.get(key).votes));
			//System.out.println(pt+"after"+candidatemap.get(key).party);
		}
		int max=0;;
		Iterator itt = pt.keySet().iterator();
		Heap<String,String> lpo = new Heap<String,String>();
		while(itt.hasNext()){
			String k = (String)itt.next();
			if(pt.get(k)==max){
				lpo.insert(k,k);
			}
			else if(pt.get(k)>max){
				lpo = new Heap<String,String>();
				lpo.insert(k,k);
				max=pt.get(k);
			}
		}
		ArrayList<String> wq= lpo.sort();
		for(int i=0;i<wq.size();i++)
		System.out.println(wq.get(i));
	}
	public void voteShareInState(String party,String state){
		State st = bst.findVal(state);
		System.out.println((int)st.voteshare(party));
	}
	public void updateVote(String name,String candID,String votes){
		String statename=candidatemap.get(candID).state;
		String partyname=candidatemap.get(candID).party;
		String districtname=candidatemap.get(candID).district;
		String constituencyname=candidatemap.get(candID).constituency;
		int candvotes = Integer.parseInt(candidatemap.get(candID).votes);
		State s=bst.findVal(statename);
		s.update(name,candID,votes,candvotes,constituencyname,partyname);
		candidatemap.get(candID).votes = votes;
		ans.update(candID,new Candidate(name,candID,statename,districtname,constituencyname,partyname,votes));
	}
	public void cancelVoteConstituency(String c){
		State st = bst.findVal(constituencymap.get(c));
		st.cancelVoteConstituency(c);
		// System.out.println("C ");
			Heap<String,String> t = cc.get(c);
			ArrayList<String> arr = new ArrayList<String>();
			arr=t.sort();
			cc.remove(c);
			constituencymap.remove(c);
		for(int i=0;i<arr.size();i++){
			// System.out.println("C "+arr.get(i));
			ans.delete(arr.get(i));
			candidatemap.remove(arr.get(i));
		}

	}
	public void topkInConstituency(String constituency,String k){
		State st = bst.findVal(constituencymap.get(constituency));
		ArrayList<String> ans = st.topkInConstituency(constituency,k);
		// System.out.println("size "+ans.size());
		for(int i=0;i<ans.size();i++){
			System.out.println(ans.get(i));
		}
	}
	public void leadingPartyInState(String state){
		// State st = bst.findVal(state);
		// ArrayList<String> ans = st.leadingparty();
		// for(int i=0;i<ans.size();i++)
		// System.out.println(ans.get(i));
		HashMap<String,Integer> pt=new HashMap<String,Integer>();
		Iterator it = candidatemap.keySet().iterator();
		while(it.hasNext()){
			String key = (String)(it.next());
			//System.out.println(pt+"before"+candidatemap.get(key).party+" "+Integer.parseInt(candidatemap.get(key).votes));
			//String pname = candidatemap.get(key).party;
			if(candidatemap.get(key).state.equals(state))
			pt.put(candidatemap.get(key).party,pt.getOrDefault(candidatemap.get(key).party,0)+Integer.parseInt(candidatemap.get(key).votes));
			//System.out.println(pt+"after"+candidatemap.get(key).party);
		}
		int max=0;;
		Iterator itt = pt.keySet().iterator();
		Heap<String,String> lpo = new Heap<String,String>();
		while(itt.hasNext()){
			String k = (String)itt.next();
			if(pt.get(k)==max){
				lpo.insert(k,k);
			}
			else if(pt.get(k)>max){
				lpo = new Heap<String,String>();
				lpo.insert(k,k);
				max=pt.get(k);
			}
		}
		ArrayList<String> wq= lpo.sort();
		for(int i=0;i<wq.size();i++)
		System.out.println(wq.get(i));
	} 
	public void printElectionLevelOrder(){
    	ArrayList<Candidate> c = ans.printSpecialClass();
    	for(int i=0;i<c.size();i++){
    		Candidate e = c.get(i);
    		System.out.println(e.name+", "+e.candID+", "+e.state+", "+e.district+", "+e.constituency+", "+e.party+", "+e.votes);
    	}
}
}


class Candidate implements Comparable<Candidate>{
	String name;
	String candID;
	String state;
	String district;
	String constituency;
	String party;
	String votes;
	public Candidate(String a,String b,String c,String d,String e,String f,String g){
		name=a;
		candID=b;
		state=c;
		district=d;
		constituency=e;
		party=f;
		votes=g;
	}
	public int compareTo(Candidate o){
		return Integer.parseInt(this.votes)-Integer.parseInt(o.votes);
	}
}

class Constituency implements Comparable<Constituency>{
  	String name;
  	public Constituency(String name){
  		this.name=name;
  	}
    public int compareTo(Constituency o){
      return name.compareTo(o.name);
    }
  	Heap<String,const_cand> h=new Heap<String,const_cand>();
    HashMap<String,Integer> partycount = new HashMap<String,Integer>();
    int totalvotes=0; 
  	public ArrayList<String> topkInConstituency(int k){
  		ArrayList<const_cand> temp=new ArrayList<const_cand>();
  		ArrayList<String> ans=new ArrayList<String>();
  		for(int i=0;i<k;i++){
  			const_cand cc = h.extractMax();
  			if(cc==null) break;
  			temp.add(cc);
  			String t=temp.get(i).name+", "+temp.get(i).candID+", "+temp.get(i).party;
  			ans.add(t);
  		} 
  		for(int i=0;i<temp.size();i++){
  			h.insert(temp.get(i).candID,temp.get(i));
  		}
  		return ans;
  	}
  	public void insert(Candidate c){
      int v = Integer.parseInt(c.votes);
      totalvotes+=v;
      partycount.put(c.party,partycount.getOrDefault(c.party,0)+v);
  		h.insert(c.candID,new const_cand(c.name,c.candID,c.party,c.votes));
  	}
  	public ArrayList<String> winningparty(){
      ArrayList<const_cand> tt = h.sort();
      int max=Integer.parseInt(tt.get(0).vote);
      Heap<String,String> ans = new Heap<String,String>();
      int i=0;
      while(i<tt.size()&&Integer.parseInt(tt.get(i).vote)==max){
        ans.insert(tt.get(i).party,tt.get(i).party);
        i++;
      }
      return ans.sort();
  	}
  	public void update(String name,String candID,String votes,int oldvotes,String party){
      int v = Integer.parseInt(votes);
      totalvotes+=v-oldvotes;
      partycount.put(party,partycount.getOrDefault(party,0)-oldvotes+v);
  		h.increaseKey(candID,new const_cand(name,candID,party,votes));
  	}
class const_cand implements Comparable<const_cand>{
  String name;
  String vote;
  String candID;
  String party;
  public const_cand(String a,String b,String c,String d){
    name=a;
    candID=b;
    party=c;
    vote=d;
  }
  public int compareTo(const_cand o){
      return Integer.parseInt(this.vote)-Integer.parseInt(o.vote);
  }
}
}

class State implements Comparable<State>{
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
	public ArrayList<String> leadingparty(){
		ArrayList<Constituency> temp = bst.values;
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		for(int i=0;i<temp.size();i++){
			ArrayList<String> t = temp.get(i).winningparty();
			for(int k=0;k<t.size();k++)
			h.put(t.get(k),h.getOrDefault(t.get(k),0)+1);
		}
		int max = 0;
		Iterator it = h.keySet().iterator();
		Heap<String,String> ans = new Heap<String,String>();
		while(it.hasNext()){
			String k = (String)it.next();
			if(h.get(k)==max){
				ans.insert(k,k);
			}
			else if(h.get(k)>max){
				ans = new Heap<String,String>();
				ans.insert(k,k);
				max=h.get(k);
			}
		}
		return ans.sort();
	}
	public void cancelVoteConstituency(String c){
		Constituency ct = bst.findVal(c);
		totalvotes-=ct.totalvotes;
		Iterator it = partycount.keySet().iterator();
		while(it.hasNext()){
			String key = (String)(it.next());
			if(ct.partycount.get(key)!=null){
				// System.out.println("Hi1");
				partycount.put(key,partycount.get(key)-ct.partycount.get(key));
		    }
		}
		// System.out.println("Hi");
		bst.delete(c);
		// System.out.println("Hi2");

	}
	public void update(String name,String candID,String votes,int oldvotes,String constituency,String party){
		Constituency c=bst.findVal(constituency);
		c.update(name,candID,votes,oldvotes,party);
		int v = Integer.parseInt(votes);
		partycount.put(party,partycount.getOrDefault(party,0)-oldvotes+v);
		totalvotes+=v-oldvotes;
	}
	public ArrayList<String> topkInConstituency(String constituency,String k){
		Constituency ct = bst.findVal(constituency);
		return ct.topkInConstituency(Integer.parseInt(k));
	}
	public float voteshare(String party){
		return ((float)partycount.get(party)/(float)totalvotes)*100;
	}
}