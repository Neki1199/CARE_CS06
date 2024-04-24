/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cwk4.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aam
 */
public class T5MeetChallengeTest {
    CARE game;
    
    public T5MeetChallengeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Jean");
    }
    
    @After
    public void tearDown() {
    }

    
//Wizards    
    // Wizard facing magic
    @Test
    public void wizardFacingMagicWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.meetChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicWinsMoney() {
        int expected = 1000-400+100;
        game.enterChampion("Ganfrank");
        game.meetChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicLosesOnSkill() {
        int expected = 1;
        game.enterChampion("Neon");
        int actual = game.meetChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.meetChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
      
    @Test
    public void wizardLosingIsDisqualified() {
        game.enterChampion("Neon");
        game.meetChallenge(1);
        boolean actual = game.getChampionDetails("Neon").toLowerCase().contains("disqualified");
        assertTrue(actual);
    }
    
    //checking withdrawal of disqualified champion
    @Test
    public void cantWithdrawDead() {
        int expected = 1;
        game.enterChampion("Neon");
        game.meetChallenge(1);
        int actual= game.retireChampion("Neon");
        assertEquals(actual,expected);
    }
    
    @Test
    public void cantWithdrawDisqualifiedMoneyNotAffected() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.meetChallenge(1);
        game.retireChampion("Neon");
        int actual= game.getMoney();
        assertEquals(actual,expected);
    }

    @Test
    public void wizardFacingNoSuchMagic() {
        int expected = -1;
        game.enterChampion("Ganfrank");
        int actual = game.meetChallenge(14);
        assertEquals(expected, actual);
    } 
    
    // Wizard facing fight
    @Test
    public void wizardFacingFightWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.meetChallenge(2);
        assertEquals(expected, actual);
    }
    
   @Test
    public void wizardFacingFightWinsMoneyAdded() {
        int expected = 1000-400+120;
        game.enterChampion("Ganfrank");
        game.meetChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    } 
    
    @Test
    public void wizardFacingFightLosesOnSkill() {
        int expected = 1;
        game.enterChampion("Neon");
        int actual = game.meetChallenge(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingFightLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.meetChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    // Wizard facing mystery
    @Test
    public void wizardFacingMysteryWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.meetChallenge(3);
        assertEquals(expected, actual);
    }
    
   @Test
    public void wizardFacingMysteryWinsMoneyAdded() {
        int expected = 1000-400+150;
        game.enterChampion("Ganfrank");
        game.meetChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    } 
    
    @Test
    public void wizardFacingMysteryLosesOnSkill() {
        int expected = 1;
        game.enterChampion("Neon");
        int actual = game.meetChallenge(3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMysteryLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-150;
        game.enterChampion("Neon");
        game.meetChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
   
//Warriors
    //Warrior facing magic - not allowed
    @Test
    public void warriorFacingMagicNotAllowed() {
        int expected = 2;
        game.enterChampion("Argon");
        game.meetChallenge(1);
        int actual = game.meetChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingMagicNotAllowedMoneyDeducted() {
        int expected = 0;
        game.enterChampion("Argon");
        game.meetChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
  
    //Warrior facing fight
    @Test
    public void warriorFacingFightAllowedWins() {
        int expected = 0;
        game.enterChampion("Argon");
        int actual = game.meetChallenge(2);
        assertEquals(expected, actual);
    }
      
    @Test
    public void warriorFacingFightAllowedWinsMoneyAdded() {
        int expected = 220;
        game.enterChampion("Argon");
        game.meetChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingFightAllowedLosesOnSkill() {
        int expected = 1;
        game.enterChampion("Flimsi");
        int actual = game.meetChallenge(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingFightAllowedLosesMoneyDeducted() {
        int expected = 680;
        game.enterChampion("Flimsi");
        game.meetChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    //Warrior facing mystery - not allowed
    @Test
    public void warriorFacingMysteryNotAllowed() {
        int expected = 2;
        game.enterChampion("Argon");
        game.meetChallenge(3);
        int actual = game.meetChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingMysteryNotAllowedMoneyDeducted() {
        int expected = -50;
        game.enterChampion("Argon");
        game.meetChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    // Dragons - OWN TESTS
    // Dragons facing magic - not allowed
    @Test
    public void dragonFacingMagicNotAllowed() {
        int expected = 2;
        game.enterChampion("Drabina");
        int actual = game.meetChallenge(4);
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingMagicNotAllowedMoneyDeducted() {
        int expected = 1000-500-200;
        game.enterChampion("Drabina");
        game.meetChallenge(4);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    // Dragons facing fight
    @Test
    public void dragonFacingFightAllowedWins() {
        int expected = 0;
        game.enterChampion("Drabina");
        int actual = game.meetChallenge(10);
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingFightAllowedWinsMoneyAdded() {
        int expected = 1000-500+300;
        game.enterChampion("Drabina");
        game.meetChallenge(10);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingFightAllowedLosesOnSkill() {
        int expected = 1;
        game.enterChampion("Drabina");
        int actual = game.meetChallenge(8);
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingFightAllowedLosesMoneyDeducted() {
        int expected = 1000-500-170;
        game.enterChampion("Drabina");
        game.meetChallenge(8);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    // Dragons facing mystery - if they do not talk (not allowed)
    @Test
    public void dragonFacingMysteryNotAllowed() {
        int expected = 2;
        game.enterChampion("Drabina");
        int actual = game.meetChallenge(3);
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingMysteryNotAllowedMoneyDeducted() {
        int expected = 1000-500-150;
        game.enterChampion("Drabina");
        game.meetChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    //Dragons facing mystery - if they talk (allowed)
    // win
    @Test
    public void dragonFacingMysteryAllowed() {
        int expected = 0;
        game.enterChampion("Golum");
        int actual = game.meetChallenge(3);
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingMysteryAllowedMoneyAdded() {
        int expected = 1000-500+150;
        game.enterChampion("Golum");
        game.meetChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    // lost on skills
    @Test
    public void dragonFacingMysteryAllowedLost() {
        int expected = 1;
        game.enterChampion("Golum");
        int actual = game.meetChallenge(9);
        assertEquals(expected, actual);
    }

    @Test
    public void dragonFacingMysteryAllowedMoneyDeductedLost() {
        int expected = 1000-500-300;
        game.enterChampion("Golum");
        game.meetChallenge(9);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
}
