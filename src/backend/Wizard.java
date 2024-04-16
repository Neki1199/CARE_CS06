package backend;

import cwk4.ChallengeType;

/**
 * A class representing the wizard object inheriting from Champion
 *
 * @author (Thomas)
 * @version (08/04/24)
 */
public class Wizard extends Champion
{

    private String spell;
    private boolean necromancer;

    /**
     * Constructor for objects of class Wizard
     */
     public Wizard(String name, int skillLevel, String spell, boolean necromancer) {
        super(name, necromancer ? 400 : 300, skillLevel);
        this.spell = spell;
        this.necromancer = necromancer;
        
    }

    /**Returns a String name the wizards spell
     * @return a String of spell
     **/
    public String getSpell() 
    {
        return spell;
    }

    /**Returns a Boolean of if the wizard is a necromancer
     * @return a Boolean of necromance
     **/
    public boolean isNecromancer() 
    {
        return necromancer;
    }

    /**Returns a Boolean denoting if the champion can complete a challenge task
     * @param challenge is a ChallengeType to check for that specific challenge
     * @return a Boolean of false
     **/
    public boolean canMeet(ChallengeType challenge)
    {
          return true;
    }

    /**Returns a String representation of the state of the wizard objects,
     * including the name of the champion, their cost,
     * What its skill level is, the name of its signature spell, and whether it's a necromancer 
     * 
     * @return a String representation of the state of the objects,
     * including the name of the champion, their cost,
     * What its skill level is, the name of its signature spell, and whether it's a necromancer 
     **/
    public String toString()
    {
        String top = super.toString();
        return top + "Necromancer: " + this.necromancer + "\nSpecial Spell: " + this.spell + "\nType: Wizard\n";
    }
}
