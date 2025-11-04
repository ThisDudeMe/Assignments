
package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

public class MarketRoomTest {
    
    private Player player;
    private MarketRoom room;
    private FakeUI fakeUI;
    
    @BeforeEach
    public void setUp() {
        player = new Player("Test Player", 100, 100, 10);
        room = new MarketRoom();
        fakeUI = new FakeUI();
    }
    
    @Test
    public void testPlayerBuysSwordWhenHavingEnoughPoints() {
        fakeUI.setInput("ja");
        int initialStrength = player.getStrength();
        int initialScore = player.getScore();
        
        room.enterRoom(player, fakeUI);
        
        assertEquals(initialStrength + 5, player.getStrength(), "Player strength should increase by 5");
        assertEquals(initialScore - 40, player.getScore(), "Player score should decrease by 40");
    }
    
    @Test
    public void testPlayerCannotBuySwordWithoutEnoughPoints() {
        player = new Player("Poor Player", 100, 20, 10);
        fakeUI.setInput("ja");
        int initialStrength = player.getStrength();
        int initialScore = player.getScore();
        
        room.enterRoom(player, fakeUI);
        
        assertEquals(initialStrength, player.getStrength(), "Player strength should not change");
        assertEquals(initialScore, player.getScore(), "Player score should not change");
    }
    
    @Test
    public void testPlayerDeclinesPurchase() {
        fakeUI.setInput("nej");
        int initialStrength = player.getStrength();
        int initialScore = player.getScore();
        
        room.enterRoom(player, fakeUI);
        
        assertEquals(initialStrength, player.getStrength(), "Player strength should not change");
        assertEquals(initialScore, player.getScore(), "Player score should not change");
    }
}
