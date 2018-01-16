public class Farm extends Matrix{
    
  public Farm(){//automatically generates a 2 row, 2 column matrix as a farm
    super();
    for (int r = 1;r <= 2; r++){
      for(int c = 1; c <= 2; c++)
        set(r,c,"O");
    }
  }
    
  public Farm(int n){//generates a n row n column matrix as a farm
    super(n);
    for (int r = 1; r <= n; r ++){
      for(int c = 1; c <= n; c ++){
        String s = new String("X");
        set(r,c,s);
      }
    }
    for (int r = 1; r <= 2; r ++){
      for(int c = 1; c <= 2; c++){
        String s = new String("O");
        set(r,c,s);
      }
    }
    
  }
    
  public Object getCucumber(int r, int c){ //calls on Matrix's get method to implement GetCucumber
    return get(r,c);
  }
    
  public void plant(int r, int c, Object O){//calls on Matrix's set method to implement setCucumber
    set(r, c, O);
  }
    
  public int harvest(int r, int c){
    if (getCucumber(r,c).equals("O")){
      System.out.println("You selected an open space instead of a cucumber. Select again please.");
        return 0;
      }
    
    String s = new String("O");
    Cucumber C = (Cucumber)getCucumber(r,c);
    int retMoney = C.value;
    set(r,c,s);
    return retMoney;
  }
    
  public static void main(String[] args){
    Farm F = new Farm();
    F.plant(1,1,"O");
    System.out.println(F.get(1,1));
  }
    

}
