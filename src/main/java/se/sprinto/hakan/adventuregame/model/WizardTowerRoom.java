package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class WizardTowerRoom implements Room {
    
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kliver in i ett högt torn. En trollkarl står där och erbjuder sin hjälp!");
        Wizard wizard = new Wizard("Gandalf", 50, 0, 8, 50);
        
        String choice = ui.getInput("Vill du be trollkarlen bota dig? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            int healthBefore = player.getHealth();
            wizard.castHealingSpell(player);
            int healthAfter = player.getHealth();
            
            if (healthAfter > healthBefore) {
                ui.showMessage("Trollkarlen botar dig! Ditt HP är nu: " + player.getHealth());
                player.addScore(30);
            } else {
                ui.showMessage("Trollkarlen har inte tillräckligt med mana för att bota dig.");
            }
        } else {
            ui.showMessage("Du tackar nej och lämnar tornet.");
        }
    }
}
