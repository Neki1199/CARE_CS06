package backend;

import cwk4.ChallengeType;

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
    public Dragon(String name, Boolean talks)
    {
        super(name, 500, 7);
        this.talks = talks;
        
    }

    /**Returns a Boolean denoting if the champion can complete a challenge task
     * @param challenge is a ChallengeType to check for that specific challenge
     * @return a Boolean of false
     **/
    public boolean canMeet(ChallengeType challenge)
    {
          if (challenge == ChallengeType.FIGHT)
          {
               return true;
          }
          else if (challenge == ChallengeType.MYSTERY && this.talks)
          {
               return true;
          }
          return false;
    }
    
    /**Returns a String representation of the state of the objects,
         * including the name of the champion, their cost,
         * What it's cost is, and whether it talks 
         * 
         * @return a String representation of the state of the objects,
         * including the name of the champion, their cost,
         * What it's cost is, and whether it talks 
         **/
    public String toString()
    {
        String top = super.toString();
        return top + "Talks: " + this.talks + "\nType: Dragon\n";
     }
}
