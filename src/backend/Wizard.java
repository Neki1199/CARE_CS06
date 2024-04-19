package backend;

import cwk4.ChallengeType;

/**
 * A class representing the Wizard object inherited from Champion
 *
 * @author Thomas B.
 * @version 08/04/24
 */
public class Wizard extends Champion
{
    private String spell;
    private boolean necromancer;

    /** Constructor for objects of class Wizard
     * If the Wizard is a necromancer, entry fee is set to 400, 300 otherwise
     * @param name String of the Wizard name
     * @param skillLevel int of the skill level
     * @param spell String of the Wizard's special spell
     * @param necromancer Boolean true if the Wizard is necromancer, or false
     **/
     public Wizard(String name, int skillLevel, String spell, boolean necromancer) {
        super(name, necromancer ? 400 : 300, skillLevel);
        this.spell = spell;
        this.necromancer = necromancer;
    }

    /** Returns a String of the Wizard's spell
     * @return a String of the special spell
     **/
    public String getSpell() 
    {
        return spell;
    }

    /** Returns a Boolean  true if the Wizard is a necromancer
     * @return a Boolean true if the Wizard is a necromancer, false if not
     **/
    public boolean isNecromancer() { return necromancer; }

    /** Returns a Boolean denoting if the champion can complete a challenge task
     * @param challenge is a ChallengeType to check for that specific challenge
     * @return Boolean true always, as the Wizard can meet all type of challenges
     **/
    public boolean canMeet(ChallengeType challenge)
    {
          return true;
    }

    /** Returns a String representation of the state of the champion,
     * including the name of the champion, their cost, skill level, and state
     * In addition: if is necromancer, special spell and type of champion
     * @return a String about the Wizard details
     **/
    public String toString()
    {
        String top = super.toString();
        return top + "Necromancer: " + this.necromancer + "\nSpecial Spell: " + this.spell + "\nType: Wizard\n";
    }
}
