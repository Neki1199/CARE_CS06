package backend;


/**
 * Write a description of class Wizard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wizard extends Champion
{
    // instance variables - replace the example below with your own
    private String spell;
    private boolean necromancer;

    /**
     * Constructor for objects of class Wizard
     */
     public Wizard(String name, int skillLevel, String spell, boolean necromancer) {
        super(name, 0, skillLevel);
        this.spell = spell;
        this.necromancer = necromancer;
        
        if (necromancer)
        {
            this.setCost(400);
        }
        else
        {
            this.setCost(300);
        }
    }

    /**
     * Method to get the spell of the wizard
     */
    public String getSpell() 
    {
        return spell;
    }
    
    public boolean getMagic()
    {
         return true;   
    }
    
    public boolean getFight()
    {
         return true;   
    }
    
    public boolean getMystery()
    {
         return true;   
    }

    /**
     * Method to check if the wizard is a necromancer
     */
    public boolean isNecromancer() 
    {
        return necromancer;
    }
    
    public String toString()
    {
        return "Wizard (name='" + getName() + "', cost=" + getCost() + ", skillLevel=" + getSkillLevel() +
                ", spell='" + spell + "', necromancer=" + necromancer + ")";
    }
}
