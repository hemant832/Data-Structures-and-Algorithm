public class User{
	int id;
	int lastseen=-1;
	MySet<Subscription> following=new MySet<>();
	//MySet<Subscription> unfollowing=new MySet<>();
    MySet<Text> text=new MySet<>();

}