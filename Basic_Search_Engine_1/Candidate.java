package col106.assignment3.Election;
public class Candidate implements Comparable<Candidate>{
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