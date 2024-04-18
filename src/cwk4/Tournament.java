package cwk4;
import backend.*;

import java.util.*;
import java.io.*;
/**
 * This interface specifies the behaviour expected from CARE
 * as required for 5COM2007 Cwk 4
 * 
 * @author Thomas B., Yanelky C., Derick O., Frederica T.
 * @version 16/04/2024
 */

public class Tournament implements CARE
{
    private String vizier;
    private Integer treasury;


    private ArrayList<Challenge> challenges = new ArrayList<Challenge>();


    private HashMap<String, Champion> team = new HashMap<String, Champion>();
    private HashMap<String, Champion> reserves = new HashMap<String, Champion>();
    



//**************** CARE ************************** 
    /** Constructor requires the name of the vizier
     * @param viz the name of the vizier
     */  
    public Tournament(String viz)
    {
        vizier = viz;
        treasury = 1000;
      
        
       setupChampions();
       setupChallenges();
    }
    
    /** Constructor requires the name of the vizier and the
     * name of the file storing challenges
     * @param viz the name of the vizier
     * @param filename name of file storing challenges
     */  
    public Tournament(String viz, String filename)  //Task 3.5
    {
        vizier = viz;
        treasury = 1000;
        

        setupChampions();
        readChallenges(filename);
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    {
        return "************** State of Game **************\nVizier: " + this.vizier +  "\nTreasury: " + this.treasury + "\nDefeated: " +
                isDefeated() + this.getTeam() + "\n";
    }
    
    
    /** returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     * @return true if Treasury <=0 and the vizier's team has no
     * champions which can be retired. 
     */
    public boolean isDefeated()
    {
        if (getMoney() <= 0)
        {
            for (Champion champ : this.team.values())
            {
                if(champ.getState() == ChampionState.ENTERED)
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney()
    {
        return this.treasury;
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {   
        String s = "\n************ Champions available in reserves ********";
        for (Champion i : this.reserves.values())  
        { 
            s += "\n" + i.toString();
        }
        return s;
    }
    
        
    /** Returns details of the champion with the given name. 
     * Champion names are unique.
     * @return details of the champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
        if (team.containsKey(nme))
        {
            return team.get(nme).toString(); 
        }
        else if(reserves.containsKey(nme))
        {
            return reserves.get(nme).toString();
        }
       
        return "\nNo such champion";
    }    
    
    /** returns whether champion is in reserve
    * @param nme champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme)
    {
        if(reserves.containsKey(nme))
        {
            return true;
        }
        return false;
    }
 
    // ***************** Team champions ************************   
     /** Allows a champion to be entered for the vizier's team, if there 
     * is enough money in the Treasury for the entry fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the vizier's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme)
    {
        if(!isInReserve(nme))
        {
            if(!isInViziersTeam(nme))
            {
                return -1;
            }
            return 1;
        }

        Champion champ = reserves.get(nme);

        if((getMoney() - champ.getCost()) <= 0)
        {
            return 2;
        }
        
        champ.setState(ChampionState.ENTERED);
        this.team.put(nme, champ);
        this.reserves.remove(nme);
        this.treasury -= champ.getCost();

        return 0;

    }
        
     /** Returns true if the champion with the name is in 
     * the vizier's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the vizier's team, false otherwise.
     **/
    public boolean isInViziersTeam(String nme)
    {
        if(team.containsKey(nme))
        {
            return true;
        }
        return false;
    }
    
    /** Removes a champion from the team back to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because disqualified
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme)
    {
        if(!isInViziersTeam(nme))
        {
            if(!isInReserve(nme))
            {
                return -1;
            }
            return 2;
        } 

        Champion champ = this.team.get(nme);

        if(champ.getState() == ChampionState.DISQUALIFIED)
        {
            return 1;
        }

        champ.setState(ChampionState.WAITING);

        this.treasury += champ.getCost() / 2;
        this.team.remove(nme);
        this.reserves.put(nme, champ);
        return 0;
    }
    
    
        
    /**Returns a String representation of the champions in the vizier's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the vizier's team
     **/
    public String getTeam()
    {
        String s = "\n************ Vizier's Team of Champions ********";
        if(this.team.size() >= 1)
        {
            for (Champion i : team.values()) 
            {
                    s += "\n" + i.toString();
            }
            return s;
        }
        return "\nNo champions entered";
    }
    
     /**Returns a String representation of the disqualified champions in the vizier's team
     * or the message "No disqualified champions "
     * @return a String representation of the disqualified champions in the vizier's team
     **/
    public String getDisqualified()
    {
        int countDisqualified = 0;
        String s = "************ Vizier's Disqualified Champions ********";
        for (Champion i : team.values()) {
            if(i.getState() == ChampionState.DISQUALIFIED)
            {
                countDisqualified += 1;
                s += "\n" + i.toString();
            }
        }

        if(countDisqualified > 0){
            return s;
        } else {
            return "\nNo disqualified champions";
        }
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the  number of the challenge
     * @return true if the  number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         Challenge challengeNo = getAChallenge(num);
         if(challengeNo != null){
             return true;
         }
         return false;
     }    
   
    /** Provides a String representation of a challenge given by
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {
        Challenge challengeToGet = getAChallenge(num);
        if(challengeToGet != null){
            return challengeToGet.toString();
        }
        return "\nNo such challenge";
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        String s = "\n************ All Challenges ************\n";
        for(Challenge tempChal: this.challenges){
            String chalInfo = tempChal.toString();
            s += chalInfo + "\n";
        }
        return s;
    }
    
    
    /** Retrieves the challenge represented by the challenge 
     * number.Finds a champion from the team who can meet the 
     * challenge. The results of meeting a challenge will be 
     * one of the following:  
     * 0 - challenge won by champion, add reward to the treasury, 
     * 1 - challenge lost on skills  - deduct reward from
     * treasury and record champion as "disqualified"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and vizier completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int meetChallenge(int chalNo)
    {
        //Nothing said about accepting challenges when bust
        int outcome = -1;
        if(isChallenge(chalNo))
        {
            Challenge currentChallenge = getAChallenge(chalNo);
            Champion challengerChampion = getChampionForChallenge(currentChallenge);

            if(challengerChampion == null)
            {
                outcome = 2;
                treasury -= currentChallenge.getReward();
            }
            else
            {
                if(challengerChampion.getSkillLevel() > currentChallenge.getSkill())
                {
                    outcome = 0;
                    treasury += currentChallenge.getReward();
                }
                else
                {
                    outcome = 1;
                    treasury -= currentChallenge.getReward();

                    team.get(challengerChampion.getName()).setState(ChampionState.DISQUALIFIED);

                    if(isDefeated())
                    {
                        outcome = 3;
                    }
                }
            }

        }
        
        return outcome;
    }

    private boolean isChampion(String nme)
    {
        if(team.containsKey(nme) || reserves.containsKey(nme))
        {
            return true;
        }
        return false;
    }
 

    //****************** private methods for Task 3 functionality*******************
    //*******************************************************************************
    /** Add Champions into a map where (name, champion)  */
    private void setupChampions()
    {
        Wizard c1 = new Wizard("Ganfrank", 7, "transmutation", true);
        reserves.put("Ganfrank", c1);

        Wizard c2 = new Wizard("Rudolf", 6, "invisibility", true);
        reserves.put("Rudolf", c2);

        Warrior c3 = new Warrior("Elblond", 150,"sword");
        reserves.put("Elblond", c3);

        Warrior c4 = new Warrior("Flimsi", 200,"bow");
        reserves.put("Flimsi", c4);

        Dragon c5 = new Dragon("Drabina", false);
        reserves.put("Drabina", c5);

        Dragon c6 = new Dragon("Golum", true);
        reserves.put("Golum", c6);

        Warrior c7 = new Warrior("Argon", 900,"mace");
        reserves.put("Argon", c7);

        Wizard c8 = new Wizard("Neon", 2, "translocation", false);
        reserves.put("Neon", c8);

        Dragon c9 = new Dragon("Xenon", true);
        reserves.put("Xenon", c9);

        Warrior c10 = new Warrior("Atlanta", 500,"bow");
        reserves.put("Atlanta", c10);

        Wizard c11 = new Wizard("Krypton", 8, "fireballs", false);
        reserves.put("Krypton", c11);

        Wizard c12 = new Wizard("Hedwig", 1, "flying", true);
        reserves.put("Hedwig", c12);

    }

    /** Add challenges into an ArrayList */
    private void setupChallenges()
    {
        Challenge c1 = new Challenge(1, ChallengeType.MAGIC, "Borg", 3, 100);
        Challenge c2 = new Challenge(2, ChallengeType.FIGHT, "Huns", 3, 120);
        Challenge c3 = new Challenge(3, ChallengeType.MYSTERY, "Ferengi", 3, 150);
        Challenge c4 = new Challenge(4, ChallengeType.MAGIC, "Vandal", 9, 200);
        Challenge c5 = new Challenge(5, ChallengeType.MYSTERY, "Borg", 7, 90);
        Challenge c6 = new Challenge(6, ChallengeType.FIGHT, "Goth", 8, 45);
        Challenge c7 = new Challenge(7, ChallengeType.MAGIC, "Frank", 10, 200);
        Challenge c8 = new Challenge(8, ChallengeType.FIGHT, "Sith", 10, 170);
        Challenge c9 = new Challenge(9, ChallengeType.MYSTERY, "Cardashian", 9, 300);
        Challenge c10 = new Challenge(10, ChallengeType.FIGHT, "Jute", 2, 300);
        Challenge c11 = new Challenge(11, ChallengeType.MAGIC, "Celt", 2, 250);
        Challenge c12 = new Challenge(12, ChallengeType.MYSTERY, "Celt", 1, 250);

        Collections.addAll(this.challenges, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
    }

    /** Returns a challenge with the challenge no specified by the parameter
     * @return the challenge with the specified id
     **/
     private Challenge getAChallenge(int no)
     {
        for(Challenge tempChal: this.challenges){
            int tempChalNo = tempChal.getNumber();
            if(tempChalNo == no){
                return tempChal;
            }
        }
         return null;
     }
    
     private Champion getChampionForChallenge(Challenge chal)
     {
        for (Champion champs : this.team.values())
        {
            if(champs.canMeet(chal.getType()) && champs.isActive())
            {
                return champs;
            }
            
        }
         return null;
     }

    //*******************************************************************************
    //*******************************************************************************

    /************************ Task 3.5 ************************************************/

    // ***************   file write/read  *********************
    /**
     * reads challenges from a comma-separated textfile and stores in the game
     * @param filename of the comma-separated textfile storing information about challenges
     */
    public void readChallenges(String filename)
    {
        int count = 1;
        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;

			while ((line = reader.readLine()) != null) {
                String [] info = line.split(",");
                ChallengeType type = ChallengeType.FIGHT;

                if(info[0].equals("Magic"))
                {
                    type = ChallengeType.MAGIC;
                }
                else if(info[0].equals("Mystery"))
                {
                    type = ChallengeType.MYSTERY;
                }
                
                this.challenges.add(new Challenge(count, type, info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3])));
                count++;
            }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
    }   
    
     /** reads all information about the game from the specified file 
     * and returns a CARE reference to a Tournament object, or null
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
    public Tournament loadGame(String fname)
    {   // uses object serialisation 
        Tournament deserializedObject = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fname))) {
            deserializedObject = (Tournament) inputStream.readObject(); 
            inputStream.close();
            System.out.println("Read file:" + fname);
        }
        catch (IOException e)
        {
            System.out.println("Unable to read file");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Can't load object");
        }
        return deserializedObject;
   } 
   
    /** Writes whole game to the specified file
    * @param fname name of file storing requests
    */
   public void saveGame(String fname){ //throws FileNotFoundException{
        // uses object serialisation 
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fname))) {
            outputStream.writeObject(this);
            outputStream.close();
            System.out.println("Object written to:" + fname);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("Unable to open file");
        }
        
    }
}



