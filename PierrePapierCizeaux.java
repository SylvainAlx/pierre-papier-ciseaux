import java.util.Random;
import java.util.Scanner;

public class PierrePapierCizeaux {
  public static void main(String[] arg) {
    Random random = new Random();
    int scorePlayer = 0;
    int scoreNpc = 0;

    while (scoreNpc != 3 && scorePlayer != 3) {
      switch (gameRound(playerChoice(), random.nextInt(3) + 1)) {
        case 1:
          scorePlayer++;
          break;
        case 2:
          scoreNpc++;
          break;
      }

      System.out.println("Player score: " + scorePlayer + " NPC score: " + scoreNpc);
    }

  }

  public static int playerChoice() {
    Scanner input = new Scanner(System.in);
    int choice;
    do {
      System.out.println("1 for Rock");
      System.out.println("2 for Paper");
      System.out.println("3 for Scissors");
      choice = input.nextInt();
    } while (choice > 3 || choice < 1);
    return choice;
  }

  public static String playerSelection(int selection) {
    String object = "";
    switch (selection) {
      case 1:
        object = "Rock";
        break;
      case 2:
        object = "Paper";
        break;
      case 3:
        object = "Scissors";
        break;
      default:
    }
    return object;
  }

  public static int gameRound(int playerChoice, int npcChoice) {
    int result;
    System.out
        .println(
            "your choice is " + playerSelection(playerChoice) + " the NPC choice is " + playerSelection(npcChoice));
    if (playerChoice == 1 && npcChoice == 3 || playerChoice == 2 && npcChoice == 1
        || playerChoice == 3 && npcChoice == 2) {
      System.out.println("You win the round !");
      result = 1;
    } else if (playerChoice == npcChoice) {
      System.out.println("No winner");
      result = 0;
    } else {
      System.out.println("You lost the round, the npc wins !");
      result = 2;
    }
    return result;
  }
}
