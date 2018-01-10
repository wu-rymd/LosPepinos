public class User
{
    private int money;
    private String name;
    
    
    public User()
    {
	name = "";
	money = 30;
    }
    public User(String n)
    {
	this();
	name = n;
    }

    public void plant(int xcor, int ycor, int selection)
    {
	String Sselection = ""+selection;
	if (Sselection == "1"){
	    English eng = new English();
	    Farm.plant(xcor, ycor, eng);
	}
	else if (Sselection == "2"){
	    Kirby kir = new Kirby();
	    Farm.plant(xcor, ycor, kir);
	}

	else if (Sselection == "3"){
	    Persian per = new Persian();
	    Farm.plant(xcor, ycor, per);
	}

	else if (Sselection == "4"){
	    Armenian arm = new Armenian();
	    Farm.plant(xcor, ycor, arm);
	}

	else if (Sselection == "5"){
	    Japanese jpn = new Japanese();
	    Farm.plant(xcor, ycor, jpn);
	}
	    
    }
    public static void main(String[] args){
	User lim = new User();
	System.out.println(lim.plant(1,2,1));
    }
}
