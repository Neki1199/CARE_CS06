package cwk4; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "team number";
        
        details[1] = "surname of member1";
        details[2] = "first name of member1";
        details[3] = "SRN of member1";

        details[4] = "Castillo Almonte";
        details[5] = "Yanelky";
        details[6] = "21051432";

        details[7] = "Otoo";
        details[8] = "Derick";
        details[9] = "21058424";


        details[10] = "Beadle";
        details[11] = "Thomas";
        details[12] = "22013613";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
