package se.sprinto.hakan.adventuregame.model;

public class Merchant extends AbstractCharacter {
    private int gold;
    
    public Merchant(String name, int health, int score, int strength, int gold) {
        super(name, health, score, strength);
        this.gold = gold;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    @Override
    public void attack(AbstractCharacter target) {
        // Merchant is not a fighter, does minimal damage
        target.setHealth(target.getHealth() - this.getStrength());
    }
    
    public boolean trade(Player player, int cost) {
        if (player.getScore() >= cost) {
            player.addScore(-cost);
            this.gold += cost;
            return true;
        }
        return false;
    }
}
