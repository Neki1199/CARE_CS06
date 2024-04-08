package backend;
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
        * @param name champion's name
        * @param cost champion's cost
        * @param weapon is the champion's signature weapon
    
    * @return true if champion in reserve, false otherwise
    */
    public Warrior(String name, int cost, String weapon)
    {
        super(name, cost, Math.floorDiv(cost, 100));
        this.weapon = weapon;        
    }

    /**Returns a Boolean denoting if the champion can complete a magic task
     * @return a Boolean of false
     **/
    public boolean getMagic()
    {
         return false;   
    }

    /**Returns a Boolean denoting if the champion can complete a fight task
     * @return a Boolean of true
     **/
    public boolean getFight()
    {
         return true;   
    }

    /**Returns a Boolean denoting if the champion can complete a mystery task
     * @return a Boolean of false
     **/
    public boolean getMystery()
    {
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
        return "Warrior (name='" + getName() + "', cost=" + getCost() + ", skillLevel=" + getSkillLevel() +
                ", weapon='" + weapon + ")";
    }
}
