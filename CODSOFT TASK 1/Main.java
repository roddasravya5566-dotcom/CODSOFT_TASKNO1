import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {
            int number = random.nextInt(100) + 1; // 1 to 100
            int attempts = 5;
            boolean won = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + attempts + " attempts.");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You won!");
                    score++;
                    won = true;
                    break;
                } 
                else if (guess < number) {
                    System.out.println("Too low!");
                } 
                else {
                    System.out.println("Too high!");
                }
            }

            if (!won) {
                System.out.println("You lost! The number was: " + number);
            }

            System.out.println("Your score: " + score);
            System.out.print("Play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Final Score: " + score);
        System.out.println("Game Over!");
    }
}