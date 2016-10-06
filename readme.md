# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Project: Rock Paper Scissors

#### Overview

Let's put your Java knowledge to use! You're going to be creating a basic version of Rock Paper Scissors that you play against the computer in the console. The game consists of two main features:

- Play Rock Paper Scissors against a computer player
- View previous game history

**Hint:** Use a [random number generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html) to pick the computer's choice.

---

#### Requirements

Your work must:

- Have a main menu with options to enter "play" or "history":
  - If the user enters "play", they should be able to play Rock Paper Scissors against the computer
  - If the user enters "history", the program should display previous game history
- Handle invalid user input
- Use Arrays or ArrayLists to store game history

**Bonus:**

- Handle incorrect capitalization of otherwise valid user input (rock, Rock, RoCk, ROCK, etc.)
- Store game history across sessions

---


#### Code of Conduct

As always, your app must adhere to General Assembly's [student code of conduct guidelines](https://github.com/ga-adi-macaron/Course-Materials/blob/master/markdown/code-of-conduct.md).

If you have questions about whether or not your work adheres to these guidelines, please speak with a member of your instructional team.

---

#### Necessary Deliverables

Submit a pull request with a Java program that meets the above requirements.

Below, you can see sample output:

```
Welcome to Rock Paper Scissors!

MAIN MENU
=====
1. Type 'play' to play
2. Type 'history' to view your game history
Type 'quit' to stop playing

play


Type in 'rock' 'paper' or 'scissors' to play.
 Type 'quit' to go back to the Main Menu

rock
Computer picks: scissors
User picks: rock
You win!

Welcome to Rock Paper Scissors!

MAIN MENU
=====
1. Type 'play' to play
2. Type 'history' to view your game history
Type 'quit' to stop playing

play


Type in 'rock' 'paper' or 'scissors' to play.
 Type 'quit' to go back to the Main Menu

paper
Computer picks: scissors
User picks: paper
You lose!

Welcome to Rock Paper Scissors!

MAIN MENU
=====
1. Type 'play' to play
2. Type 'history' to view your game history
Type 'quit' to stop playing

history
=== GAME HISTORY ===
WIN: Player-rock computer-scissors
LOSS: Player-paper computer-scissors

Welcome to Rock Paper Scissors!

MAIN MENU
=====
1. Type 'play' to play
2. Type 'history' to view your game history
Type 'quit' to stop playing

quit
```

---

#### Suggested Ways to Get Started

- Don’t hesitate to write throwaway code to solve short term problems
- Read the docs for whatever technologies you use.** Most of the time, there is a tutorial that you can follow, but not always, and learning to read documentation is crucial to your success as a developer
- Write pseudocode before you write actual code.** Thinking through the logic of something helps.   

---

### Useful Resources

- [Random number generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
- [Rules, history of Rock Paper Scissors](https://en.wikipedia.org/wiki/Rock-paper-scissors)

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
