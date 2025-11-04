package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class LibraryRoom implements Room {
    
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du hittar ett gammalt bibliotek fullt med dammiga böcker.");
        
        String choice = ui.getInput("Vill du läsa en av böckerna? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Du läser en bok om forntida visdom och får kunskap!");
            player.addScore(50);
            ui.showMessage("Dina poäng ökade med 50! Totalt: " + player.getScore());
        } else {
            ui.showMessage("Du lämnar biblioteket utan att läsa något.");
        }
    }
}
