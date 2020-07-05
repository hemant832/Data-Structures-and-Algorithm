package col106.assignment3.Election;
import java.util.ArrayList;
import java.util.HashMap;
public class Constituency implements Comparable<Constituency>{
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
  	public ArrayList<String> topKinConstituency(int k){
  		ArrayList<const_cand> temp=new ArrayList<const_cand>();
  		ArrayList<String> ans=new ArrayList<String>();
  		for(int i=0;i<k;i++){
  			temp.add(h.extractMax());
  			String t=temp.get(i).name+" "+temp.get(i).candID+" "+temp.get(i).party;
  			ans.add(t);
  		} 
  		for(int i=0;i<k;i++){
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
  	public String winningparty(){
  		const_cand temp=h.extractMax();
  		h.insert(temp.candID,temp);
  		return temp.party;
  	}
  	public void update(String name,String candID,String votes,int oldvotes,String party){
      int v = Integer.parseInt(votes);
      totalvotes+=v-oldvotes;
      partycount.put(party,partycount.getOrDefault(party,0)-oldvotes+v);
  		h.update(candID,new const_cand(name,candID,party,votes));
  	}
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