package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DungeonRoomTest {

    @Test
    public void testPlayerDefeatsEnemyByAttacking(){

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        Player player = new Player.Builder().name("Test Player").health(100).score(0).strength(10).build();

        DungeonRoom dungeonRoom = new DungeonRoom();
        dungeonRoom.enterRoom(player, fakeUI);
        assertTrue(player.hasDefeatedEnemy(),"Player should have defeated enemy");


    }

}
