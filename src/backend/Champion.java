package backend;

import cwk4.ChallengeType;
import cwk4.ChampionState;

/**
 * A parent Class which the other champions are built off
 *
 * @author Thomas B.
 * @version 08/04/24
 */
public abstract class Champion
{
    private String name;
    private int cost;
    private int skillLevel;
    private ChampionState state;
    
    
    /** Constructor for objects of class Champion
     * State from the ChampionState class [Waiting, Entered, Disqualified]
     * @param name String of the champion's name
     * @param cost int of the champion's entry fee
     * @param skillLevel int of the champion's skill level
     **/
    protected Champion(String name, int cost, int skillLevel) 
    { 
        this.name = name;
        this.cost = cost;
        this.skillLevel = skillLevel;
        this.state = ChampionState.WAITING;
    }
    
    /** Returns a String of the champion's name.
     * @return a String representation of the champion's name
     **/
    public String getName()
    {
        return this.name;
    }

    /** Returns an int of the champion's cost
     * @return an int of the champion's cost
     **/
    public int getCost()
    {
        return this.cost;
    }
    
     /** Returns an int of the champion's skill level.
     * @return an int of the champion's skill level
     **/
    public int getSkillLevel()
    {
        return this.skillLevel;
    }

    /** An abstract method that returns a Boolean denoting if the champion can complete a challenge task
     * @param type is a ChallengeType to check for that specific challenge
     * @return a Boolean true if it can meet a challenge, false otherwise
     **/
    public abstract boolean canMeet(ChallengeType type);
    
    /** Sets the ChampionsState state of the champion
    * @param state represents the champions new state
    **/
    public void setState(ChampionState state) 
    {
        this.state = state;
    }

    /** Returns the current state of the champion
    * @return current ChampionState of the champion
    **/
    public ChampionState getState() 
    {
        return this.state;
    }
  
    /** Returns a Boolean of the champion's current active state
     * @return a Boolean true if the champion is entered, false otherwise
     **/
    public boolean isActive() 
    {
        return this.state == ChampionState.ENTERED;
    }
  
    /** Returns a String representation of the state of the champion,
     * including the name of the champion, their cost, skill level, and state
     * @return a String about the champion details
     **/
     public String toString()
     {
        return "***Champion***\nName: " + this.name + "\nCost: " + this.cost + "\nSkill Level: " + this.skillLevel +
                "\nState: " + this.state.toString() + "\n";
     }
}
