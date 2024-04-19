package backend;

import cwk4.ChallengeType;

/**
 * Class Challenge to create all game challenges
 *
 * @author Thomas B.
 * @version 08/04/24
 */
public class Challenge
{
    private int number;
    private ChallengeType type;
    private String enemy;
    private int skill;
    private int reward;

    /** Constructor for objects of class Challenge
     * @param number int of the challenge's unique number
     * @param type what kind of challenge it is expected from ChallengeType class [Magic, Fight, Mystery]
     * @param enemy String with the name of the enemy
     * @param skill int of the challenge skill requirement
     * @param reward int of the challenge reward value
     */
    public Challenge(int number, ChallengeType type, String enemy, int skill, int reward)
    {
        this.number = number;
        this.type = type;
        this.enemy = enemy;
        this.skill = skill;
        this.reward = reward;
    }

    /** Returns an int of the challenge number
     * @return an int of challenge number
     **/
    public int getNumber() 
    {
        return number;
    }

    /** Returns a String of the challenge type
     * @return String of type expected from [Magic, Fight, Mystery]
     **/
    public ChallengeType getType() 
    {
        return type;
    }

    /** Returns String of enemy name
     * @return String of the enemy name
     **/
    public String getEnemy() 
    {
        return enemy;
    }

    /** Returns an int of the skill level of the challenge
     * @return int of the skill level requirement
     **/
    public int getSkill() 
    {
        return skill;
    }

    /** Returns an int of the challenge reward
     * @return int of challenge reward
     **/
    public int getReward() 
    {
        return reward;
    }

    /** Returns a String with all the challenge details
     * @return String of all challenge details
     */
    public String toString(){
        return "***Challenge details***\nChallenge No: " + getNumber() + "\nChallenge type: " +
                getType() + "\nEnemy name: " + getEnemy() + "\nSkill level: " +
                getSkill() + "\nReward: " + getReward() + "\n";
    }
}
