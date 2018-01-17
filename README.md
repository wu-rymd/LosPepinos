## LosPepinos
APCS1 Final Project

LosPepinos
* Kerwin Chen
* Raymond Wu
* Jerry Ye

# Cucumber
Superclass for all the species of cucumbers

  * English <br>
  * Persian <br>
  * Kirby <br>
  * Armenian <br>
  * Japanese <br>

# Woo <br>
Driver file for our game

# User <br>
class that creates a user (the player)

# Farm <br>
extends matrix, comtains the methods that deal with farm interaction
<br>
# DO WE NEED ANYTHING BELOW THIS LINE

# General description
Our final project proposal is to create an in-terminal simulation of cucumber farming. The goal of the game is to generate as much profit as possible in 15 “weeks.” Each week is defined as a stage in the game.

At the beginning of the game, the user starts with 4 plots of land.

At the beginning of each stage, the user interacts with his or her farm by planting, fertilizing, and/or harvesting his or her cucumbers, or he/she can purchase seeds of different cucumber species. While cucumber species that are highly nutritious grow, they also generate money. When the user “harvests” cucumbers, he or she automatically sells them for money at a price that depends on the value of the cucumber based on the amount of time needed to grow. More nutritious cucumbers are more costly. The user may also spend his or her money on more plots of land.

If the user attempts to plant in a plot of land he or she does not own, he or she must either pay a fine or “go to jail” (the game ends).

The game must end when the user has no money left or 15 weeks have elapsed.

# Instructions
1. Run Woo.java in a command-line interface.
   * ``$ javac Woo.java``
   * ``$ java Woo.java``
2. Input the user character's name.
3. Follow user input prompts on the command-line interface.
