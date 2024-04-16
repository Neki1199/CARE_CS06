package backend;

import cwk4.ChallengeType;

/**
 * A class representing the Warrior object inheriting from Champion
 *
 * @author (Thomas)
 * @version (08/04/24)
 */
public class Warrior extends Champion
{
    private String weapon;

    /**
     * Constructor for objects of class Warrior
        * @param name champion's name
        * @param cost champion's cost
        * @param weapon is the champion's signature weapon
    
    */
    public Warrior(String name, int cost, String weapon)
    {
        super(name, cost, Math.floorDiv(cost, 100));
        this.weapon = weapon;        
    }

     /**Returns a Boolean denoting if the champion can complete a challenge task
     * @param challenge is a ChallengeType to check for that specific challenge
     * @return a Boolean of false
     **/
    public boolean canMeet(ChallengeType challenge)
    {
          if (challenge == ChallengeType.FIGHT)
          {
               return true;
          }
          return false;
    }


    /**Returns a String representation of the state of the object,
     * including the name of the champion, their cost,
     * What it's skill level is, and its weapon 
     * 
     * @return a String representation of the state of the objects,
     * including the name of the champion, their cost,
     * What it's skill level is, and its weapon 
     **/
    public String toString()
    {
          String top = super.toString();
          return "Warrior: " + top.substring(9, top.length()-1) + ", Weapon= " + this.weapon + ")";
     }
}
