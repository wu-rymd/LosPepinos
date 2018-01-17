// LosPepinos (Kerwin Chen, Raymond Wu, Jerry Ye)
// APCS1 pd1
// 2018-01-06

/*

This is the Cucumber superclass. It defines the properties of any Cucumber.

The String variable name will hold the descriptive name of the Cucumber species.

The int variable nutrition will hold the amount of nutrition the Cucumber has. The amount of nutrition will help determine the value of the Cucumber.

The int variable ripeDuration will hold the amount of time it takes for a Cucumber to fully grow, in weeks. This will help determine the toString name of the Cucumber.

The int variable value will hold the value of the Cucumber. This is what the Cucumber can be sold for after if it is harvested.

*/


public class Cucumber
{

    public String name;
    public int nutrition, ripeDuration, value;
    
    public void grow()
    {
	ripeDuration -= 1;
	if (ripeDuration >= 0)
	    value += nutrition;
	else
	    value -= nutrition;
	if (value < 0)
	    value = 0;
    }
 
    public String toString()
    { return name + ripeDuration; }
    
}
    
