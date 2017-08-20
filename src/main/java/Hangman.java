import java.util.Scanner;
import java.util.Random;

public class Hangman {
  public static void main(String[] args) {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

  //Create an Array to store my words that the user should guess
    String[] words = {"army", "orange", "dinosaur", "kitenge", "delamere","peel"};
    boolean gamePlay = true;

  while (gamePlay) {
      System.out.println("Play Game");
      //Pick a random word from the words array.
      char[] randomWordArr = words[random.nextInt(words.length)].toCharArray();
      int totalGuesses = randomWordArr.length;///Add more chances here later.
      char[] playerGuess = new char[totalGuesses];

    //convert all the elements in the array an underscore
      for (int ges = 0; ges < playerGuess.length ; ges ++ ) {
          playerGuess[ges] = '_';
        }
          boolean correctGuess = false;
          int tries = 0;

        while(!correctGuess && tries != totalGuesses) {
            System.out.println("Correct Guesses:");
            //function to display the array of correct Guesses, dashes(_ _ _) if  empty
            printArray(playerGuess);
            //output to show tries left
            System.out.printf("You have %d tries left.\n", totalGuesses - tries);

          //prompt user to enter  a new character ,ONLY one character can be accepted
            System.out.println("Enter a single Letter");
            char input =  scanner.nextLine().charAt(0);
            tries ++;
            //if the player enters '-' the game ends
            if (input == '-') {
              //gamePlay = false;
              correctGuess = true;
            } else {
                for (int ind = 0; ind < randomWordArr.length ; ind ++ ) {
                  if(randomWordArr[ind] == input) {
                  playerGuess[ind] = input;
                }
              }
                if (isCorrectlyGuessed(playerGuess)) {
                correctGuess = true;
                System.out.println("Congrats. You win!!!!");
                printArray(playerGuess);

            }
            }


        }
          if(!correctGuess) System.out.println("You ran out of guesses");
          System.out.println("Play again?(yes/no)");

        String newGame = scanner.nextLine();
          if(newGame.equals("no")) gamePlay = false;



  }
    System.out.println("Game Over!");
  }
  //public method to print player guesses
    public static void printArray(char[] array){
      for (int x= 0; x < array.length ; x ++ ) {
        System.out.print(array[x] + "  ");
      }
      System.out.println();
    }

  //public method to check if
     public static boolean isCorrectlyGuessed(char[] array) {
     for (int y =0; y< array.length  ; y ++ ) {
       if (array[y] == '_') return false;
     }
     return true;


}
}