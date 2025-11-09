package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryRoomTest {

    private Player player;
    private LibraryRoom room;
    private FakeUI fakeUI;

    @BeforeEach
    public void setUp() {
        player = new Player("Test Player", 100, 0, 10);
        room = new LibraryRoom();
        fakeUI = new FakeUI();
    }

    @Test
    public void testPlayerGainsScoreWhenReadingBook() {
        fakeUI.setInput("ja");
        int initialScore = player.getScore();

        room.enterRoom(player, fakeUI);

        assertEquals(initialScore + 50, player.getScore(), "Player score should increase by 50");
    }

    @Test
    public void testPlayerScoreUnchangedWhenNotReadingBook() {
        fakeUI.setInput("nej");
        int initialScore = player.getScore();

        room.enterRoom(player, fakeUI);

        assertEquals(initialScore, player.getScore(), "Player score should not change");
    }
}
