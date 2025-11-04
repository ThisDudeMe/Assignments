package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class MarketRoom implements Room {
    
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kommer till en marknadsplats. En köpman vill sälja dig en magisk svärd!");
        Merchant merchant = new Merchant("Köpmannen", 30, 0, 3, 100);
        
        ui.showMessage("Dina nuvarande poäng: " + player.getScore());
        ui.showMessage("Svärdet kostar 40 poäng men ökar din styrka med 5!");
        
        String choice = ui.getInput("Vill du köpa svärdet? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            if (merchant.trade(player, 40)) {
                player.setStrength(player.getStrength() + 5);
                ui.showMessage("Du köper svärdet! Din nya styrka är: " + player.getStrength());
            } else {
                ui.showMessage("Du har inte tillräckligt med poäng för att köpa svärdet.");
            }
        } else {
            ui.showMessage("Du lämnar marknaden utan att köpa något.");
        }
    }
}
