import cs1.Keyboard;
import java.util.Scanner;

public class Woo
{
    // ~~~ INSTANCE VARIABLES ~~~
    private int weeksElapsed;
    private String name;

    
    // ~~~~~~~~ METHODS ~~~~~~~~~
    public void startGame()
    {
	String s;
	s = "~~~ Welcome to Cucumber Farm! ~~~\n"

	    s += "\nWhat is your name, dearest Farmer? "
	    name = Keyboard.readString();
	System.out.println("Hello, " + name);
	
    } // end startGame method


    
    public void playGame()
    {
	String s;
	int selection;

        showStats();
		
	s =  "\n" + name + ", what is your next step?";
	s += "\t1: Buy a seed and plant it!\n";
	s += "\t2: Harvest a cucumber!\n";
	s += "\t3: Buy a plot of land!\n";
	s += "\t4: Start next day!\n";

	s += "\nYou have $ " + u.getMoney() + " left.";
	s += "\nThere are " + (15 - weeksElapsed) + " weeks left in the game.";
	System.out.println(s);
		
	selection = Keyboard.readInt();


	if (selection == 1)
	    plant();

	else if (selection == 2)
	    harvest();

	else if (selection == 3)
	    buyLand();
	
	else if (selection == 4)
	    weeksElapsed++;
	// increment weeksElapsed, and back to main menu

	else
	    System.out.println("\nFollow directions!");
	// back to main menu, without incrementing weeksElapsed
	
	    
	
    } // end playGame method



    public void printCucumberInfo()
    {
	String cucumberInfo;
	cucumberInfo =  "\nArmenian cucumber:\n";
	cucumberInfo += "\tNutrition: 20\n";
	cucumberInfo += "\tRipe duration: 5 weeks\n";
	cucumberInfo += "\tCost to buy: $30\n";

	cucumberInfo += "\nEnglish cucumber:\n";
	cucumberInfo += "\tNutrition: 5\n";
	cucumberInfo += "\tRipe duration: 2 weeks\n";
	cucumberInfo += "\tCost to buy: $3\n";

	cucumberInfo += "\nJapanese cucumber:\n";
	cucumberInfo += "\tNutrition: 25\n";
	cucumberInfo += "\tRipe duration: 6 weeks\n";
	cucumberInfo += "\tCost to buy: $50\n";

	cucumberInfo += "\nKirby cucumber:\n";
	cucumberInfo += "\tNutrition: 10\n";
	cucumberInfo += "\tRipe duration: 3 weeks\n";
	cucumberInfo += "\tCost to buy: $10\n";

	cucumberInfo += "\nPersian cucumber:\n";
	cucumberInfo += "\tNutrition: 15\n";
	cucumberInfo += "\tRipe duration: 4 weeks\n";
	cucumberInfo += "\tCost to buy: $20\n";

	System.out.println( cucumberInfo);

    } // end printCucumberInfo method

    

    public void plant()
    {
	String s, cucumberInfo;
	int selection, xcor, ycor;

	s =  "\n" + name + "What type of cucumber would you like to plant?";
	s += "\t1: Armenian\n";
	s += "\t2: English\n";
	s += "\t3: Japanese\n";
	s += "\t4: Kirby\n";
	s += "\t5: Persian\n";
	s += "\t6: See more info about Cucumbers!\n";

	System.out.println(s);

	selection = Keyboard.readInt();

	if (selection == 1 || selection == 2 || selection == 3 ||
	    selection == 4 || selection == 5)
	    {
		s = "\nIn which row would you like to plant?\n";
		System.out.println(s);
		xcor = Keyboard.readInt();
		xcor -= 1; // convert from matrix index to array index

		s = "\nIn which column would you like to plant?\n";
		System.out.println(s);
		ycor = Keyboard.readInt();
		ycor -= 1; // convert from matrix index to array index

		if ( f[xcor][ycor] == "x")
		    {
			System.out.println("\nYou don't own land here! $50 penalty!");
			u.setMoney( u.getMoney() - 50);
			System.out.println("\nYou now have $" + u.getMoney() );
		    }
		
	    } // end if statement for x-cor, y-cor
	
	if (selection == 1)
	    {
		Cucumber c = new Armenian();
		f.plant(xcor, ycor, c);

		u.setMoney( u.getMoney() - 30);
		System.out.println("\nThat cost you $30. You now have $" + u.getMoney() );
	    }

	else if (selection == 2)
	    {
		Cucumber c = new English();
		f.plant(xcor, ycor, c);

		u.setMoney( u.getMoney() - 3);
		System.out.println("\nThat cost you $3. You now have $" + u.getMoney() );
	    }

	else if (seletion == 3)
	    {
		Cucumber c = new Japanese();
		f.plant(xcor, ycor, c);

		u.setMoney( u.getMoney() - 50);
		System.out.println("\nThat cost you $50. You now have $" + u.getMoney() );
	    }

	else if (selection == 4)
	    {
		Cucumber c = new Kirby();
		f.plant(xcor, ycor, c);

		u.setMoney( u.getMoney() - 10);
		System.out.println("\nThat cost you $10. You now have $" + u.getMoney() );
	    }

	else if (selection == 5)
	    {
		Cucumber c = new Persian();
		f.plant(xcor, ycor, c);

		u.setMoney( u.getMoney() - 20);
		System.out.println("\nThat cost you $20. You now have $" + u.getMoney() );
	    }

	else if (selection == 6)
	    {
		printCucumberInfo();
		// back to main menu, without incrementing weeksElapsed
	    }

	else
	    {
		System.out.println("\nFollow directions!");
		// back to main menu, without incrementing weeksElapsed
	    }
	
    } // end plant method



    public void harvest()
    {
	int xcor, ycor;
	
	System.out.println( "\nThe plant you would like to harvest...");
	System.out.println( "\n\tis in which row?");
	xcor = Keyboard.readInt();
	xcor -= 1; // convert from matrix index to array index

        System.out.println( "\n\tis in which column?");
	ycor = Keyboard.readInt();
	ycor -= 1; // convert from matrix index to array index

	if ( f[xcor][ycor] == "x" || f[xcor][ycor] == "o")
	    System.out.println("\nYou don't have anything planted here!"x);
	// back to main menu, without incrementing weeksElapsed

	else
	    f.harvest(xcor, ycor);
	
    } // end harvest method



    public void buyLand()
    {
	int xcor, ycor;
	
	System.out.println( "\nThe plot of land  you would like to buy...");
	System.out.println( "\n\tis in which row?");
	xcor = Keyboard.readInt();
	xcor -= 1; // convert from matrix index to array index

        System.out.println( "\n\tis in which column?");
	ycor = Keyboard.readInt();
	ycor -= 1; // convert from matrix index to array index

	if ( !(f[xcor][ycor] == "x") )
	    {
		if ( xcor > f.length || ycor > f.length )
		    System.out.println( "\nThis plot of land does not exist in the world!");
		else
		    System.out.println( "You already own this plot of land!");

	    } // end if
	
    } // end buyLand method
    
    
    
    public void endGame()
    {
	if !(weeksElapsed < 15)
	    System.out.println("\nTime's up! Your time as a Farmer is over.");

	else !( u.getMoney() > 0)
		 System.out.println("\nYou ran out of money! Probably better to run a farm in a Communist country instead.");

	System.out.println("\nHere is the final resting state of your farm:\n");
	System.out.println(f);

	System.out.println("\n\n" + "You had $" + u.getMoney() + " when you died.");
	
    } // end endGame method
	    

    
    public String showStats()
    {
	System.out.println(f);
	System.out.println( "\n\nYou have $" + u.getMoney() );
    } // end showStats method


    
    public static void main(String[] args)
    {
	User u = new User();
	Farm f = new Farm(5);
	
	startGame();
	while ( weeksElapsed < 15 &&
		u.getMoney() > 0     )
	    playGame()
	// does not update weeksElapsed b/c will be updated when chosen by user

	endGame();
	
    } // end main method

} // end Woo class
