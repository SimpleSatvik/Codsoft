import java.util.Random;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) 
    {
        Game game = new Game();
        game.Play();
    }
}

class Game
{
    private int correctNumber;
    private int attempts = 0;
    private int guessNumber;
    private String status;

    Game()
    {
        Random random = new Random();
        correctNumber = random.nextInt(100) + 1; //Generates number between 1 and 100
    }

    public void Play()
    {
        System.out.println("WELCOME TO THE NUMBER GAME!");
        Scanner sc = new Scanner(System.in);
        
        while(attempts <= 5)
        {
            System.out.print("\nGuess the number : ");
            guessNumber = sc.nextInt();

            if ( Check() == true )
            {
                System.out.println("CONGRATS! YOU WON THE GAME!");
                break;
            }

            else
            {
                System.out.println("Oops! Wrong Guess :( ");
                
                if(guessNumber < correctNumber)
                    System.out.println("The Correct number is LARGER than " + guessNumber);
                
                else
                    System.out.println("The Correct number is SMALLER than " + guessNumber);

                incrementAttempts();
            }
        }

        if(Check() == false)
        {
            System.out.println("You ran out of attempts!");
            status = "LOST";
        }
            

        showScore();
    }
    
    public boolean Check()
    {
        if (guessNumber == correctNumber)
        {
            status = "WON";
            return true;
        }
            
        
        else
            return false;
    }

    public int showCorrectNumber()
    {
        return correctNumber;
    }


    public void incrementAttempts()
    {
        attempts += 1;
    }

    public int showAttempts()
    {
        return attempts;
    }

    public String showStatus()
    {
        return status;
    }

    public void showScore()
    {
        System.out.println("\n                    Your Score                       ");
        System.out.println("------------------------------------------------------");
        System.out.println("Correct Number : " + showCorrectNumber());
        System.out.println("Result : " + showStatus());
        System.out.println("Number of attempts taken : " + showAttempts());
    }
}