package se.sprinto.hakan.adventuregame.model;

public class Wizard extends AbstractCharacter {
    private int mana;

    public Wizard(String name, int health, int score, int strength, int mana) {
        super(name, health, score, strength);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(AbstractCharacter target) {
        // Wizard does extra damage if has mana
        int damage = this.getStrength();
        if (mana >= 10) {
            damage += 5; // Magic bonus
            mana -= 10;
        }
        target.setHealth(target.getHealth() - damage);
    }

    public void castHealingSpell(AbstractCharacter target) {
        if (mana >= 20) {
            target.setHealth(target.getHealth() + 15);
            mana -= 20;
        }
    }
}
