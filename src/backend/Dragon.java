package backend;

import cwk4.ChallengeType;

/**
 * A class representing the Dragon object inherited from Champion
 *
 * @author Thomas B.
 * @version 08/04/24
 */
public class Dragon extends Champion 
{
    private boolean talks;

    /** Constructor for object of class Dragon
     * The cost of 500, and skill level of 7, are default values
     * @param name String of the Dragon's name
     * @param talks a Boolean true if the dragon talks, false otherwise
     **/
    public Dragon(String name, Boolean talks)
    {
        super(name, 500, 7);
        this.talks = talks;
    }

    /** Returns a Boolean denoting if the champion can complete a challenge task
     * @param challenge is a ChallengeType to check for that specific challenge
     * @return a Boolean true if it can meet a challenge, false otherwise
     **/
    public boolean canMeet(ChallengeType challenge)
    {
          if (challenge == ChallengeType.FIGHT) {
               return true;
          } else {
              return challenge == ChallengeType.MYSTERY && this.talks;
          }
    }

    /** Returns a String representation of the state of the champion,
     * including the name of the champion, their cost, skill level, and state
     * In addition: if the dragon talks, and type of champion
     * @return a String about the champion details
     **/
    public String toString()
    {
        String top = super.toString();
        return top + "Talks: " + this.talks + "\nType: Dragon\n";
     }
}
