package backend;

import cwk4.ChallengeType;

/**
 * Write a description of the class Challenge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Challenge
{
    private int number;
    private ChallengeType type;
    private String enemy;
    private int skill;
    private int reward;

    /**
     * Constructor for objects of class Warrior
    * @param number the challenge's unique number
    * @param type what kind of challenge it is expected from [Magic, Fight, Mystery]
    * @param enemy the name of the challenge enemy
    * @param skill is the champion's skill requirement
    * @param reward is the champion's reward value
    */
    public Challenge(int number, ChallengeType type, String enemy, int skill, int reward)
    {
        this.number = number;
        this.type = type;
        this.enemy = enemy;
        this.skill = skill;
        this.reward = reward;
    }

    /**Returns an Int for the challenges ID
     * @return an Int of number
     **/
    public int getNumber() 
    {
        return number;
    }

    /**Returns String for challenge type
     * @return string of type expected from [Magic, Fight, Mystery]
     **/
    public ChallengeType getType() 
    {
        return type;
    }

    /**Returns String for enemy name
     * @return string of the enemy name
     **/
    public String getEnemy() 
    {
        return enemy;
    }

    /**Returns an int of the skill level of the challenge
     * @return int of the skill requirement
     **/
    public int getSkill() 
    {
        return skill;
    }

    /**Returns an int of the skill level of the challenge
     * @return int of the skill requirement
     **/
    public int getReward() 
    {
        return reward;
    }

    public String toString(){

        return "***Challenge details***\nChallenge No: " + getNumber() + "\nChallenge type: " +
                getType() + "\nEnemy name: " + getEnemy() + "\nSkill level: " +
                getSkill() + "\nReward: " + getReward() + "\n";
    }
}
