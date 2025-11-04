package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

public class WizardTowerRoomTest {
    
    private Player player;
    private WizardTowerRoom room;
    private FakeUI fakeUI;
    
    @BeforeEach
    public void setUp() {
        player = new Player("Test Player", 50, 0, 10);
        room = new WizardTowerRoom();
        fakeUI = new FakeUI();
    }
    
    @Test
    public void testPlayerGetsHealedWhenAcceptingWizardHelp() {
        fakeUI.setInput("ja");
        int initialHealth = player.getHealth();
        int initialScore = player.getScore();
        
        room.enterRoom(player, fakeUI);
        
        assertTrue(player.getHealth() > initialHealth, "Player health should increase");
        assertTrue(player.getScore() > initialScore, "Player score should increase");
    }
    
    @Test
    public void testPlayerHealthUnchangedWhenDecliningWizardHelp() {
        fakeUI.setInput("nej");
        int initialHealth = player.getHealth();
        int initialScore = player.getScore();
        
        room.enterRoom(player, fakeUI);
        
        assertEquals(initialHealth, player.getHealth(), "Player health should not change");
        assertEquals(initialScore, player.getScore(), "Player score should not change");
    }
}
