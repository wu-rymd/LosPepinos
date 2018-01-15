public class Farm extends Matrix{
  public Farm(){//automatically generates a 2 row, 2 column matrix as a farm
    super();
  }
  public Farm(int n){//generates a n row n column matrix as a farm
    super(n);
  }
  public Object getCucumber(int r, int c){ //calls on Matrix's get method to implement GetCucumber
    super.get(r,c);
  }
  public void setCucumber(int r, int c, Object O){//calls on Matrix's set method to implement setCucumber
    super.set(r, c, O);
  }

}
