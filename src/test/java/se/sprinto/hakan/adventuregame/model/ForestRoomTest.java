package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest {

    @Test
        public void testPlayerFindsKeyWhenAnsweringYes(){

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        Player player = new Player.Builder().name("Test Player").health(100).score(0).strength(10).build();
        ForestRoom forestRoom = new ForestRoom();
        forestRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasFoundKey(), "Player should have found key");




    }
}
