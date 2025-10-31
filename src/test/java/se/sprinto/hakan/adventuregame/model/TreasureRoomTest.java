package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TreasureRoomTest {

    @Test
    public void TestChestOpensWhenPlayerHasKey(){

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        Player player = new Player("Test Player", 100, 0, 10);
        TreasureRoom treasureRoom = new TreasureRoom();
        treasureRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasOpenedChest(), "Player should have opened chest");
    }

    @Test
    public void TestChestDoesNotOpenWhenPlayerDoesNotHaveKey(){

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("nej");

        Player player = new Player("Test Player", 100, 0, 10);

        TreasureRoom treasureRoom = new TreasureRoom();
        treasureRoom.enterRoom(player, fakeUI);

        assertFalse(player.hasOpenedChest(), "Player should not have opened chest");
    }

}
