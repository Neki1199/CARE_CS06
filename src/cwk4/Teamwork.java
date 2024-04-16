package cwk4; 


/**
 * Details of your team
 * 
 * @author Thomas B., Yanelky C., Derick O., Frederica T.
 * @version 16/04/2024
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
        details[0] = "CS06";
        
        details[1] = "Beadle";
        details[2] = "Thomas";
        details[3] = "22013613";

        details[4] = "Castillo Almonte";
        details[5] = "Yanelky";
        details[6] = "21051432";

        details[7] = "Otoo";
        details[8] = "Derick";
        details[9] = "21058424";


        details[10] = "Teather";
        details[11] = "Frederica";
        details[12] = "21094244";

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
        
