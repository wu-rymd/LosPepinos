import cs1.Keyboard;

public class Woo
{
    // ~~~ INSTANCE VARIABLES ~~~
    private static User u;
    private static Farm f;
    
    private static int weeksElapsed;
    private static String name;
    

    
    // ~~~~~~~~ METHODS ~~~~~~~~~
    public static void startGame()
    {
	String s;
	
	s = "~~~ Welcome to Cucumber Farm! ~~~\n";
	s += "\nWhat is your name, dearest Farmer?";
	System.out.println(s);
	
	name = Keyboard.readString();   // user input for username
	System.out.println("\nHello, " + name + ".\n");

	s = "\n\n~~~ HOW TO PLAY ~~~";
	s += "\nYou are the owner of a Cucumber Farm.";
	s += "\nTo begin, you will be given $50, and a 2x2 farm";
	s += "\nThe game ends when you have no money, or 15 weeks have elapsed.";
	s += "\nThe goal of the game is to make as much money as possible in 15 weeks.";

	s += "\n\nYou can buy seeds to plant on your own farm.";
	s += "\nUnplanted land that you own is marked with \"O.\"";
	s += "\nLand you do not own is marked with \"X.\" Plant here = $50 penalty!";
	s += "\nThe first row has row number 1; the second, 2; and so on. Same for columns.";

	s += "\n\nMore info on types of cucumbers by selecting See more.";
	s += "\nCucumbers increase by an increment designated as \"nutrition\".";
	s += "\nThey reach their maximum value after their \"ripe duration\", in weeks,";
	s += "\n   and begin rotting at the same rate afterward.";

	s += "\n\nYou may also choose to harvest (sell) your cucumber,";
	s += "\n   buy a plot of land for $100,";
	s += "\n   or advance to the next week to watch your cucumbers grow.";

	s += "\n\nGood luck.";

	System.out.println(s);  // print tutorial
	
    } // end startGame method


    
    public static void playGame()
    {
	String s;
	int selection;

	System.out.println("\nPress SPACE then ENTER to continue...");
	String nextStep = Keyboard.readString();

	System.out.println("\n\n===================================\n\n");
	
        printStats();  // print farm & how much money you have
		
	s =  "\n" + name + ", what is your next step? Choose wisely.\n";
	s += "\t1: Buy a seed and plant it!\n";
	s += "\t2: Harvest a cucumber!\n";
	s += "\t3: See more about Cucumbers!\n";
	s += "\t4: Buy a plot of land for $100!\n";
	s += "\t5: Start next week!\n";

	System.out.println(s);  // print options
		
	selection = Keyboard.readInt(); // user input for options


	if (selection == 1) // if user selected 1 ...
	    plant();

	else if (selection == 2)
	    harvest();

	else if (selection == 3)
	    printCucumberInfo();
	
	else if (selection == 4)
	    buyLand();
	
	
	else if (selection == 5) // user chose to start next week
	    {
		weeksElapsed++;
		for ( int r = 1; r < f.size()+1; r++)  // Matrix.java converts from matrix index --> array index
		    {
			for ( int c = 1; c < f.size()+1; c++)
			    {
				if ( !( f.getCucumber(r,c).equals("X") ) &&      // only grow Cucumbers
				     !( f.getCucumber(r,c).equals("O") )      )
				    ((Cucumber) f.getCucumber(r,c)).grow();

			    } // end inner for-loop
		    } // end outer for-loop
	    }
	// increment weeksElapsed, back to main menu

	
	else
	    System.out.println("\nFollow directions!");
	// back to main menu, without incrementing weeksElapsed
	
	    
	
    } // end playGame method



    public static void printCucumberInfo()
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

    

    public static void plant()
    {
	String s, cucumberInfo;
	int selection, xcor, ycor;

	s =  "\n" + name + ", what type of cucumber would you like to plant?\n";
	s += "\t1: Armenian (for $30)\n";
	s += "\t2: English  (for $ 3)\n";
	s += "\t3: Japanese (for $50)\n";
	s += "\t4: Kirby    (for $10)\n";
	s += "\t5: Persian  (for $20)\n";
	s += "\t6: See more info about Cucumbers!\n";

	System.out.println(s);

	selection = Keyboard.readInt();  // user input for plant selection

	if (selection == 1 || selection == 2 || selection == 3 ||
	    selection == 4 || selection == 5)
	    {
		if ( (selection == 1 && u.getMoney() < 30) ||  // does user have enough money
		     (selection == 2 && u.getMoney() < 3 ) ||  // to plant selected plant?
		     (selection == 3 && u.getMoney() < 50) ||
		     (selection == 4 && u.getMoney() < 10) ||
		     (selection == 5 && u.getMoney() < 20)     )
		    {
			System.out.println("You don't have enough money!");
			return;  // back to main menu, without incrementing weeksElapsed
		    }
		
		s = "\nIn which row would you like to plant?";
		System.out.println(s);
		xcor = Keyboard.readInt();  // converting from matrix index to array index handled by Matrix.java

		s = "In which column would you like to plant?";
		System.out.println(s);
		ycor = Keyboard.readInt();  // converting from matrix index to array index handled by Matrix.java

		if ( xcor > f.size() || ycor > f.size() ||
		     xcor <= 0       || ycor <= 0            )  // if selected plot of land out of bounds
		    {
			System.out.println( "\nThis plot of land does not exist in the world!");
			return;   // back to main menu, without incrementing weeksElapsed
		    }
		

		
		else if ( f.getCucumber(xcor, ycor).equals("X") )  // xcor, ycor in bounds of world
		    {
			System.out.println("\nYou don't own land here! $50 penalty!");
			u.setMoney( u.getMoney() - 50);
			System.out.println("\nYou now have $" + u.getMoney() );
			return;   // back to main menu, without incrementing weeksElapsed
		    }

		
		// if you arrive here, xcor and ycor in bounds of world,
		//                     and f.getCucumber(xcor, ycor) is not "X"
		// ... if not "O", means cucumber is planted in selected plot
		else if ( !( f.getCucumber(xcor, ycor).equals("O") )    )
		    {
			System.out.println("\nYou already planted here!");
			return;   // back to main menu, without incrementing weeksElapsed
		    }


		
		if (selection == 1) // selected to plant an Armenian Cucumber ...
		    {
			Cucumber c = new Armenian();
			f.plant(xcor, ycor, c);

			u.setMoney( u.getMoney() - 30);
			System.out.println("\nThat cost you $30. You now have $" + u.getMoney() + ".");
		    }

		else if (selection == 2)
		    {
			Cucumber c = new English();
			f.plant(xcor, ycor, c);

			u.setMoney( u.getMoney() - 3);
			System.out.println("\nThat cost you $3. You now have $" + u.getMoney() + ".");
		    }

		else if (selection == 3)
		    {
			Cucumber c = new Japanese();
			f.plant(xcor, ycor, c);

			u.setMoney( u.getMoney() - 50);
			System.out.println("\nThat cost you $50. You now have $" + u.getMoney() + ".");
		    }

		else if (selection == 4)
		    {
			Cucumber c = new Kirby();
			f.plant(xcor, ycor, c);

			u.setMoney( u.getMoney() - 10);
			System.out.println("\nThat cost you $10. You now have $" + u.getMoney() + ".");
		    }

		else if (selection == 5)
		    {
			Cucumber c = new Persian();
			f.plant(xcor, ycor, c);

			u.setMoney( u.getMoney() - 20);
			System.out.println("\nThat cost you $20. You now have $" + u.getMoney() + ".");
		    }

	    } // end selections 1-5 / selections needing xcor and ycor

	
	else if (selection == 6) // see Cucumber info
	    {
		printCucumberInfo();
		// back to main menu, without incrementing weeksElapsed
	    }

	
	else  // selection not in [1,6]
	    {
		System.out.println("\nFollow directions!");
		// back to main menu, without incrementing weeksElapsed
	    }
	
    } // end plant method



    public static void harvest()
    {
	int xcor, ycor;
	
	System.out.println( "\nThe plant you would like to harvest...");
	System.out.println( "\tis in which row?");
	xcor = Keyboard.readInt();  // converting from matrix index to array index handled by Matrix.java

        System.out.println( "\tis in which column?");
	ycor = Keyboard.readInt();  // converting from matrix index to array index handled by Matrix.java

	
	if ( xcor > f.size() || ycor > f.size() ||
	     xcor <= 0       || ycor <= 0             )   // chosen plot in bounds?
	    System.out.println( "\nThis plot of land does not exist in the world!");
	// back to main menu, without incrementing weeksElapsed
	
	else if ( f.getCucumber(xcor, ycor).equals("X") || f.getCucumber(xcor, ycor).equals("O") )
	    System.out.println("\nYou don't have anything planted here!");
	// back to main menu, w/o incrementing weeksElapsed

	else
	    {
		int oldMoney = u.getMoney();
		u.setMoney( u.getMoney() + f.harvest(xcor, ycor) );
		// harvest() in Farm.java returns the value of plant being harvested
		// resets plot to "O" and adds money to user's bank

		System.out.println("\nYou earned $" + ( u.getMoney() - oldMoney ) + "!");

		
	    }
	
	
    } // end harvest method



    public static void buyLand()
    {
	int xcor, ycor;

	if (u.getMoney() >= 100)   // has enough money to buy land?
	    {
		System.out.println( "\nThe plot of land you would like to buy...");
		System.out.println( "\tis in which row?");
		xcor = Keyboard.readInt(); // converting from matrix index to array index handled in Matrix.java

		System.out.println( "\tis in which column?");
		ycor = Keyboard.readInt(); // converting from matrix index to array index handled in Matrix.java
		
		if ( xcor > f.size() || ycor > f.size() ||
		     xcor <= 0       || xcor <= 0           )
		    System.out.println( "\nThis plot of land does not exist in the world!");
		// back to main menu, without incrementing weeksElapsed

		
		else if ( !(f.getCucumber(xcor, ycor).equals("X")) )   // xcor, ycor within bounds of array
		    System.out.println( "\nYou already own this plot of land!");
		// back to main menu, without incrementing weeksElapsed

		else
		    {
			u.setMoney( u.getMoney() - 100 );
			System.out.println("\nPurchase successful! $100 has been deducted.");
			f.plant(xcor, ycor, "O");
		    }
	    }

	else
	    System.out.println("\nYou don't have enough money!");
	// back to main menu, w/o incrementing weeksElapsed
	
	
    } // end buyLand method
    
    
    
    public static void endGame()
    {
	System.out.println("\n\n===================================\n\n");
	
	if ( !(weeksElapsed < 15) )  // if game ended b/c 15 weeks elapsed, print following msg
	    System.out.println("\nTime's up! Your time as a Farmer is over.");

	if ( !( u.getMoney() > 0) ) // if game ended b/c no money left, print following msg
	    System.out.println("\nYou ran out of money! Probably better to run a farm in a Communist country instead.");

	System.out.println("\nHere is the final resting state of your farm:\n");
	System.out.println(f);

	System.out.println("\n\n" + "You had $" + u.getMoney() + " when you died.");
	
    } // end endGame method
	    

    
    public static void printStats()
    {
	System.out.println(f);
	System.out.println( "You have $" + u.getMoney() + ".");
        System.out.println( "\nThere are " + (15 - weeksElapsed) + " weeks left in the game.\n");
    } // end showStats method


    
    public static void main(String[] args)
    {
	u = new User();
	f = new Farm(5);
	
	startGame();
	
	while ( weeksElapsed < 15 &&
		u.getMoney() > 0     )  // keep game running
	    playGame();
	// does not update weeksElapsed here b/c will be updated when chosen by user

	// reach here when while-loop conditions not met
	endGame();
	
    } // end main method

} // end Woo class
