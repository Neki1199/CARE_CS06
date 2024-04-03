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
        
    }

    public String getName()
    {
        return name;
    }
    
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    
    public int getCost()
    {
        return cost;
    }
    
    public void setSkill(int skill)
    {
        this.skillLevel = skill;
    }
    
    public int getSkillLevel()
    {
        return skillLevel;
    }
    
    public abstract boolean getMagic();
    
    public abstract boolean getFight();
    
    public abstract boolean getMystery();
    
    public abstract String toString();
}
