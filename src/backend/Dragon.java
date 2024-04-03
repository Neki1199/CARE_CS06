package backend;
/**
 * Write a description of class Warrior here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dragon extends Champion 
{
    // instance variables - replace the example below with your own
    private boolean talks;

    /**
     * Constructor for objects of class Dragon
     */
    public Dragon(String name, int cost, Boolean talks)
    {
        super(name, 500, 7);
        this.talks = talks;
        
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
         return this.talks;   
    }
    
    public String toString()
    {
        return "Dragon (name='" + getName() + "', cost=" + getCost() + ", skillLevel=" + getSkillLevel() +
                ", talks='" + talks + ")";
    }
}
