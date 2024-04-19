package backend;

import cwk4.ChallengeType;

/**
 * A class representing the Warrior object inherited from Champion
 *
 * @author Thomas B.
 * @version 08/04/24
 */
public class Warrior extends Champion
{
    private String weapon;

    /** Constructor for objects of class Warrior
     * The skill level is calculated by dividing the entry fee by 100
     * @param name String of Warrior's name
     * @param cost int of Warrior's cost
     * @param weapon String of the Warrior's weapon
     **/
    public Warrior(String name, int cost, String weapon)
    {
        super(name, cost, Math.floorDiv(cost, 100));
        this.weapon = weapon;        
    }

     /** Returns a Boolean denoting if the champion can complete a challenge task
     * @param challenge is a ChallengeType to check for that specific challenge
     * @return a Boolean true if the challenge is Fight type, false otherwise
     **/
    public boolean canMeet(ChallengeType challenge)
    {
        return challenge == ChallengeType.FIGHT;
    }

    /** Returns a String representation of the state of the champion,
     * including the name of the champion, their cost, skill level, and state
     * In addition: the weapon and champion type
     * @return a String about the champion details
     **/
    public String toString()
    {
        String top = super.toString();
        return top + "Weapon: " + this.weapon + "\nType: Warrior\n";
     }
}
