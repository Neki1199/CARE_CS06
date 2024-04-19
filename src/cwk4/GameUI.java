package cwk4;
import java.io.*;
import java.util.*;
/**
 * Command line interface
 * 
 * @author A.A.Marczyk
 * @version 10/03/2024
 */
public class GameUI
{
    
    private Scanner myIn = new Scanner(System.in);

    public void runGame()
    {
        Tournament tr ;
        int choice;
        String vizierName;
        String output = "";
        int result = -1; 
        try
        {
            System.out.println("Enter vizier's name");
            String s = myIn.nextLine();
            //tr = new Tournament(s); // create
            tr = new Tournament(s,"challengesAM.txt"); // alternative create task 3.5
            choice = 100;
            while (choice != 0 )
            {
                choice = getMenuItem();
                if (choice == 1)
                {
                    System.out.println(tr.getReserve());
                }
                else if (choice == 2)
                {
                    System.out.println(tr.getTeam());
                }
                else if (choice == 3)
                {
                    System.out.println("Enter Champion name: ");
                    String ref = (myIn.nextLine()).trim();
                    System.out.println(tr.getChampionDetails(ref));
                } 
                else if (choice == 4)
                {
                    System.out.println("Please pick from the champions below.");
                    System.out.println(tr.getReserve());
                    int userNumber = 3;
                    // For this option I went with putting in a loop as I felt it would be the most commonly used one.
                    while (userNumber != 0)
                    {
                        System.out.println("Enter champions name you want to add to your team, if you want to exit enter Exit");
                        String championName = (myIn.nextLine()).trim();

                        if (championName.equals("Exit")){
                            break;
                        }
                        userNumber = tr.enterChampion(championName);
                        if (userNumber == -1){
                            System.out.println("That Champion does not exist");
                        }else if (userNumber == 1){
                            System.out.println("That Champion is not in the reserves");
                        }else if (userNumber == 2){
                            System.out.println("Your too poor fam (You don't have enough money in the treasury)");
                        }else{
                            System.out.println("Champion enters the Vizier's team!");
                        }
                    }
                }
                else if (choice == 5)
                {
                    System.out.println("Please pick from the challenges below.");
                    System.out.println(tr.getAllChallenges());
                    System.out.println("Enter challenges number, if you want to exit enter 100");
                    // challengeNum is the number of the challenge used to select it in
                    int challengeNum = myIn.nextInt();

                    System.out.println("Challenge selected is ");
                    System.out.println(tr.getChallenge(challengeNum));
                    int outputNum = tr.meetChallenge(challengeNum);

                    System.out.println(processChallengeResult(outputNum));

                    System.out.print("Your money after this challenge is");
                    System.out.println(tr.getMoney());
                }
                else if (choice==6)
                {
                    System.out.println("Please pick from the team below.");
                    System.out.println(tr.getTeam());
                    System.out.println("Enter champion name, if you want to exit enter Exit");
                    String championName = (myIn.nextLine()).trim();
                    int outputNum = tr.retireChampion(championName);
                    if (outputNum == 0){
                        System.out.println("The champion has been retired");
                    } else if (outputNum == 1) {
                        System.out.println("That champion has been disqualified already");
                    } else if (outputNum == 2) {
                        System.out.println("That champion is not in your team");
                    } else{
                        System.out.println("No such champion is in the game");
                    }
                }  
                else if (choice==7)
                {
                    System.out.println(tr);
                }
                else if (choice==8)
                {
                    System.out.println(tr.getAllChallenges());
                }
                else if (choice == 9) // Task 3.5 only
                {
                    System.out.println("Write to file");
                    System.out.println("Enter file name");
                    String filename = myIn.nextLine();
                    tr.saveGame(filename);
                }
                else if (choice == 10) // Task 3.5 only
                {
                    System.out.println("Restore from file");
                    System.out.println("Enter file name");
                    String filename = myIn.nextLine();
                    CARE tr2= tr.loadGame(filename);
                    if (tr2 != null)
                    {
                        System.out.println(tr2);
                    }
                    else
                    {
                        System.out.println("No such file");
                    }
                }
            }     
        }
        catch (IOException e) {System.out.println (e);}   
        System.out.println("Thank-you");
    }
    
    private int getMenuItem()throws IOException
    {   int choice = 100;  
        System.out.println("\nMain Menu");
        System.out.println("0. Quit");
        System.out.println("1. List champions in reserve");
        System.out.println("2. List champions in viziers team"); 
        System.out.println("3. View a champion");
        System.out.println("4. Enter champion into vizier's team");
        System.out.println("5. Meet a challenge");
        System.out.println("6. Retire a champion");
        System.out.println("7. View game state");
        System.out.println("8. See all challenges");
        System.out.println("9. Save this game");
        System.out.println("10. Load this game");
       
        
        while (choice < 0 || choice  > 10)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        myIn.nextLine();
        return choice;        
    }  
    
    private String processChallengeResult(int res) {
    
        String out;
        if (res ==0)
        {
            out = "Challenge won";
        }
        else if (res ==1)
        {
            out = "Challenge lost on skill level";
        }
        else if (res ==2)
        {
            out = "Challenge lost as no champion available";
        }
        else if (res ==3)
        {
            out = "Challenge lost with no further resources. You lose the game ";
        }
        else if (res == -1)
        {
            out = "No such challenge";
        }
        else
        {
            out = "No such result";
        }
        return out; 
    }
    
    public static void main(String[] args)
    {
        new GameUI().runGame();
    }
}