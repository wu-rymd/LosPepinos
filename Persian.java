public class Persian extends Cucumber
{
    /*
      This is a Persian Cucumber, a subclass of the Cucumber class. It defines the properties that are strictly for Persian Cucumbers.

      The abbreviated name for a Persian cucumber is "Per". 
      Its nutrition is 15, which means after each day, its value grows by 15.
      Its ripe duration is 4, which means it takes 4 weeks to fully mature.
     */
    
    public Persian()  // default constructor
    {
	name = "Per";
	nutrition = 15;
	ripeDuration = 4;
    }
    
    public String about()
    { return ""; }

} // end Persian class
	
