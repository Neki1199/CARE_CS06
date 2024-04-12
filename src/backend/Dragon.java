package backend;
/**
 * A class representing the dragon object inheriting from Champion
 *
 * @author (Thomas)
 * @version (08/04/24)
 */
public class Dragon extends Champion 
{
    private boolean talks;

    /**
     * Constructor for objects of class Dragon
     */
    public Dragon(String name, int cost, Boolean talks)
    {
        super(name, 500, 7);
        this.talks = talks;
        
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
     * @return a Boolean of the object's talk value
     **/
    public boolean getMystery()
    {
         return this.talks;   
    }
    
    /**Returns a String representation of the state of the objects,
         * including the name of the champion, their cost,
         * What it's cots is, and whether it talks 
         * 
         * @return a String representation of the state of the objects,
         * including the name of the champion, thier cost,
         * What it's cots is, and whether it talks 
         **/
    public String toString()
    {
        return "Dragon (name='" + getName() + "', cost=" + getCost() + ", skillLevel=" + getSkillLevel() +
                ", talks='" + talks + ")";
    }
}
