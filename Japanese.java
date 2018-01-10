public class Japanese extends Cucumber
{
    /*
      This is a Japanese Cucumber, a subclass of the Cucumber class. It defines the properties that are strictly for Japanese Cucumbers.

      The abbreviated name for an Japanese cucumber is "Jpn". 
      Its nutrition is 25, which means after each day, its value grows by 25.
      Its ripe duration is 6, which means it takes 6 weeks to fully mature.
     */

    public Japanese()  // default constructor
    {
	name = "Jpn";
	nutrition = 25;
	ripeDuration = 6;
    }
    
    public String about()
    { return ""; }

} // end class Japanese
