package cwk4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/01/24
 */
public class GameGUI 
{
    private CARE gp = new Tournament("Fred");
    private JFrame myFrame = new JFrame("Game GUI");
    private JTextArea listing = new JTextArea();
    private JScrollPane scroll = new JScrollPane(listing);  // to scroll listing
    private JLabel codeLabel = new JLabel ();
    private JButton meetBtn = new JButton("Meet Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    public static void main(String[] args)
    {
        new GameGUI();
    }
    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());

        // Create scroll to see all the text in listing
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Add scroll (with listing in it) to frame
        myFrame.add(scroll, BorderLayout.CENTER);
        scroll.setVisible(true);
        listing.setVisible(false);

        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(viewBtn);
        eastPanel.add(meetBtn);
        eastPanel.add(clearBtn);
        eastPanel.add(quitBtn);

        viewBtn.addActionListener(new ViewBtnHandler());
        clearBtn.addActionListener(new ClearBtnHandler());
        meetBtn.addActionListener(new MeetBtnHandler());
        quitBtn.addActionListener(new QuitBtnHandler());

        viewBtn.setVisible(true);
        meetBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu championMenu = new JMenu("Champions");
        menubar.add(championMenu);

        JMenu challengeMenu = new JMenu("Challenges");
        menubar.add(challengeMenu);

        // champion menu
        JMenuItem listChampionItem = new JMenuItem("List Champions in Reserve");
        listChampionItem.addActionListener(new ListReserveHandler());
        championMenu.add(listChampionItem);

        JMenuItem listTeamItem = new JMenuItem("List Champions in Team");
        listTeamItem.addActionListener(new ListTeamHandler());
        championMenu.add(listTeamItem);

        JMenuItem viewAChampionItem = new JMenuItem("View a Champion");
        viewAChampionItem.addActionListener(new ViewAChampionHandler());
        championMenu.add(viewAChampionItem);

        JMenuItem enterChampionItem = new JMenuItem("Enter Champion in Team");
        enterChampionItem.addActionListener(new EnterChampionHandler());
        championMenu.add(enterChampionItem);

        // Challenge menu
        JMenuItem listChallengeItem = new JMenuItem("List all Challenges");
        listChallengeItem.addActionListener(new ListChallengesHandler());
        challengeMenu.add(listChallengeItem);
    }

    // Menu bar action listeners
    private class ListReserveHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            listing.setVisible(true);
            String xx = gp.getReserve();
            listing.setText(xx);
            listing.setCaretPosition(0);
        }
    }

    // Action listener to list the details of all champions in the team
    private class ListTeamHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getTeam();
            listing.setText(xx);
            listing.setCaretPosition(0);  // scroll starts at the top instead of bottom
        }
    }

    // Action listener to get one champion details. First checks if the champion exists.
    private class ViewAChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String answer = "Champion does not exist";
            String inputValue = JOptionPane.showInputDialog("Enter champion name: ");
            if(gp.isInReserve(inputValue) || gp.isInViziersTeam(inputValue)){
                answer = gp.getChampionDetails(inputValue);
            }
            JOptionPane.showMessageDialog(myFrame, answer);
        }
    }

    // Action listener to enter a champion to the team if it exists in the reserve.
    private class EnterChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result = -1;
            String answer = "Champion does not exist";
            String inputValue = JOptionPane.showInputDialog("Enter the champion's name to join the team: ");

            result = gp.enterChampion(inputValue);
            switch (result) {
                case 0 -> answer = "Champion has entered in the Vizier's team!";
                case 1 -> answer = "Champion is not in reserve";
                case 2 -> answer = "There is not enough money in the treasury, champion cannot enter the Team!";
            }
            JOptionPane.showMessageDialog(myFrame, answer);
        }
    }

    private class ListChallengesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getAllChallenges();
            listing.setText(xx);
            listing.setCaretPosition(0);  // scroll starts at the top instead of bottom
        }
    }

    // eastPanel action listeners
    private class ViewBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.toString();
            listing.setText(xx);
            listing.setCaretPosition(0);
        }
    }
   
    private class ClearBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText(" ");
        }
    }
    
    private class MeetBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String answer = "no such challenge";
            String inputValue = JOptionPane.showInputDialog("Challenge number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.meetChallenge(num);
            switch (result)
            {
                case 0:answer = "challenge won by champion"; break;
                case 1:answer = "challenge lost on skills, champion disqualified";break;
                case 2:answer = "challenge lost as no suitable champion is available";break;
                case 3:answer = "challenge lost and vizier completely defeated";break;
            }
            
            JOptionPane.showMessageDialog(myFrame,answer);    
        }
    }
    
    private class QuitBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                "Are you sure you want to quit?","Finish",
                JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }
    
}
   
