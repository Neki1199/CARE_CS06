package backend;
/**
 * Write a description of class Challenge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Challenge
{
    // instance variables - replace the example below with your own
    private int number;
    private String type;
    private String enemy;
    private int skill;
    private int reward;

    /**
     * Constructor for objects of class Challenge
     */
    public Challenge(int number, String type, String enemy, int skill, int reward)
    {
        this.number = number;
        this.type = type;
        this.enemy = enemy;
        this.skill = skill;
        this.reward = reward;
    }

    public int getNumber() 
    {
        return number;
    }

    public String getType() 
    {
        return type;
    }

    public String getEnemy() 
    {
        return enemy;
    }

    public int getSkill() 
    {
        return skill;
    }

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
