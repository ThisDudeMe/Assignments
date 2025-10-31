package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testAttackReducesEnemyHealth() {
        Player player = new Player("Test Player", 100, 0, 10);

        Enemy enemy = new Enemy("Test Enemy", 20, 0, 5);

        int initialHealth = enemy.getHealth();

        player.attack(enemy);

        int expectedHealth = initialHealth - player.getStrength();
        assertEquals(expectedHealth, enemy.getHealth(), 
                "Enemy health should have decreased by (" + player.getStrength() + ")");
    }
}
