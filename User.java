public class User
{
    private int money;
    private String name;
    
    
    public User()
    {
	name = "";
	money = 50;
    }
    
    public User(String n)
    {
	this();
	name = n;
    }

    public int getMoney(){
	return money;
    }
    
    public void setMoney(int n){
	money = n;
    }
    
    public String getName(){
	return name;
    }
    
    public void setName(String s){
	name = s; 
    }
}
