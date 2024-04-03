package backend;


/**
 * Write a description of class Warrior here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Warrior extends Champion
{
    // instance variables - replace the example below with your own
    private String weapon;

    /**
     * Constructor for objects of class Warrior
     */
    public Warrior(String name, int cost, String weapon)
    {
        super(name, cost, Math.floorDiv(cost, 100));
        this.weapon = weapon;

        
    }

    
    public boolean getMagic()
    {
         return false;   
    }
    
    public boolean getFight()
    {
         return true;   
    }
    
    public boolean getMystery()
    {
         return false;   
    }
    
    public String toString()
    {
        return "Warrior (name='" + getName() + "', cost=" + getCost() + ", skillLevel=" + getSkillLevel() +
                ", weapon='" + weapon + ")";
    }
}
