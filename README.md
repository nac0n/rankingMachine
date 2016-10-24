# rankingMachine
Elo-ranking calculator. Simple calculations to make a ELO-ranking calculations when data is provided.

Project Description
Elo-calculator

Generally, the project was created for personal use. It was created to assist with the calculation of the rankings within a community, in a compound when it is played tournaments in a particular fighting game called Touhou: Hisoutensoku.

Elo:
Elo rankings come from chess tournaments and is used to rank the player's strength relative to another. After each set / match that has been calculated, the rankings is calculated to determine the new rankings of the both players. In short, Elo-ranking is done by calculating the expected outcome of a match and then the actual result to come to a rank that is relative to the players previous ranking. If someone with higher rankings would lose against someone with lower rankings, then it becomes a major increase in the number of points to the winner than if the higher ranking would win against someone with lower rankings. The more matches a person plays and what ranking it has, generally, the amount of points is additionally reduced or increased.

Using the application:
File Selector is the first box after the information box and as the name implies, select the file that the program will use to download your .txt file, with all the people's names and ranking number. The text file must contain the name (names may not contain numbers at present), followed by the ranking numbers. After ranking numbers have been entered you have to break to a new line and write the next player.

The main screen provides the user with interactive choices to determine which ranking each player recieves.
The dropdown menu gives the user the choice between the players that are in the text file and can determine which ones have met each other. Checkboxes is used to provide with which player won. "Tournament Amount" is a text box where the user enters how many tournaments before this player has playe (This is important to calculate the ELO). "New Rank" is initially empty. When you press the "Calculate Ranking", the program calculates the Elo-ranking for both players based on the factors you have entered and displays the new ranking for you in the "New Rank" field. When you have pressed the Calculate rankings theres a new file being created that contains an updated list with the competitors. This process can repeat itself but when you exit the program, be sure to update the new data manually in your player list so that you get the updated information.

Goal:
The goal of the program was to SIMPLIFY calculation of rankings for each tournament personally. Hence shorten time. The program is also an assurance that you do not need to manually keep track of rankings and how high the factors will play into the algorithm.

---

The first challenge that arose was to first read about Elo and understand how the algorithm works on a general level at least. When the Elo algorithm could be put on paper, it was time to try to structure how the code should look like.

The future:
In the future I hope that it is possible to implement user's own rules for how the software will work and have the calculations for it. For example. the user may want to change some constants that affect the calculation of the rankings is which is quite ok, for all communities may not have the same amount of people (which also affect to some extent).

Another feature of the future will have a new button that allows you to add new players and rankings and not manually type in notepad.

After those thing, my goal is to bring this idea to a webapplication with a database in the backend using NodeJS.
