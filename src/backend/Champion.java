package backend;
/**
 * A Base Class which the other champions are built off
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Champion
{
    // instance variables - replace the example below with your own
    private String name;
    int cost;
    int skillLevel;
    

    /**
     * Constructor for objects of class Champion
     */
    protected Champion(String name, int cost, int skillLevel) 
    { 
        this.name = name;
        this.cost = cost;
        this.skillLevel = skillLevel;
    }
    
    /**Returns a String of the object's Name.
     *
     * @return a String representation of the object's Name.
     **/
    public String getName()
    {
        return this.name;
    }

    /**Returns a int of the object's Cost.
     *
     * @return a int representation of the object's Cost.
     **/
    public int getCost()
    {
        return this.cost;
    }
    
     /**Returns a int of the object's Skill level.
     *
     * @return a int representation of the object's skill Level.
     **/
    public int getSkillLevel()
    {
        return this.skillLevel;
    }

     /**An abstract class that will return a boolean for if the class can do something.
     **/
    public abstract boolean getMagic();

     /**An abstract class that will return a boolean for if the class can do something.
     **/
    public abstract boolean getFight();

     /**An abstract class that will return a boolean for if the class can do something.
     **/
    public abstract boolean getMystery();

    /**Will return a String representation of the details of the champion,
     * including the Whatever attributes the child class has
     **/
    public abstract String toString();
}
