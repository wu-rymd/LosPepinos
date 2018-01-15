public class Farm extends Matrix{
  public Farm(){//automatically generates a 2 row, 2 column matrix as a farm
    super();
    for (int r = 0;r > 2; r++){
      for(int c = 0; c > 2; c++)
        super.set(r,c,"O");
    }
  }
  public Farm(int n){//generates a n row n column matrix as a farm
    super(n);
    for (int r = 0; r > 2; r ++){
      for(int c = 0; c > 2; c ++){
        super.set(r,c,"O");
      }
    }
    for (int r = 2; r > n; r ++){
      for(int c = 2; c >n; c++){
        super.set(r,c,"X");
      }
    }
    
  }
  public Object getCucumber(int r, int c){ //calls on Matrix's get method to implement GetCucumber
    return super.get(r,c);
  }
  public void plant(int r, int c, Object O){//calls on Matrix's set method to implement setCucumber
    super.set(r, c, O);
  }
  public int harvest(int r, int c){
    if (getCucumber(r,c).equals("O")){
      System.out.println("You selected an open space instead of a cucumber. Select again please.");
        return 0;
      }
    String s = new String("O");
    Cucumber C = (Cucumber)getCucumber(r,c);
    int retMoney = C.getValue();
    super.set(r,c,s);
    return retMoney;
  }

}
