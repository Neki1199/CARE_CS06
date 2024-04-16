package backend;

import cwk4.ChallengeType;
import cwk4.ChampionState;

/**
 * A Base Class which the other champions are built off
 *
 * @author Thomas B.
 * @version (a version number or a date)
 */
public abstract class Champion
{
    // instance variables - replace the example below with your own
    private String name;
    private int cost;
    private int skillLevel;
    private ChampionState state;
    
    
    /**
     * Constructor for objects of class Champion
     */
    protected Champion(String name, int cost, int skillLevel) 
    { 
        this.name = name;
        this.cost = cost;
        this.skillLevel = skillLevel;
        this.state = ChampionState.WAITING;
    }
    
    /**Returns a String of the object's Name.
     *
     * @return a String representation of the object's Name.
     **/
    public String getName()
    {
        return this.name;
    }

    /**Returns an int of the object's Cost.
     *
     * @return an int representation of the object's Cost.
     **/
    public int getCost()
    {
        return this.cost;
    }
    
     /**Returns an int of the object's Skill level.
     *
     * @return an int representation of the object's skill Level.
     **/
    public int getSkillLevel()
    {
        return this.skillLevel;
    }

    /**An abstract class that Returns a Boolean denoting if the champion can complete a challenge task
     * @param type is a ChallengeType to check for that specific challenge
     * @return a Boolean of false
     **/
    public abstract boolean canMeet(ChallengeType type);
    
    /**Sets the ChampionsState state of the object's current state.
    *
    * @param state represents the champions current state.
    **/
    public void setState(ChampionState state) 
    {
        this.state = state;
    }

    /**Returns a ChampionsState of the object's current state.
    *
    * @return a ChampionsState of the object's current state.
    **/
    public ChampionState getState() 
    {
        return this.state;
    }
  
    /**Returns a boolean of the champion's current active state.
     *
     * @return a boolean of the champion's current active state.
     **/
    public boolean isActive() 
    {
        return this.state == ChampionState.ENTERED;
    }
  
    /**Returns a String representation of the state of the champion objects,
     * including the name of the champion, their cost,
     * What its skill level is
     * 
     * @return a String representation of the state of the objects,
     * including the name of the champion, their cost,
     * What its skill level is, 
     **/
     public String toString()
     {
        return "***Champion***\nName: " + this.name + "\nCost: " + this.cost + "\nSkill Level: " + this.skillLevel +
                "\nState: " + this.state.toString() + "\n";
     }
}
