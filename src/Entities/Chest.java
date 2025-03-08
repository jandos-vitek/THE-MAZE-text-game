package Entities;

import Others.Player;

public class Chest extends Entity {
    Player player;
    private ContentsOfChest contentsOfChest;

    public Chest(ContentsOfChest contentsOfChest, Player p) {
        this.contentsOfChest = contentsOfChest;
        this.player=p;
    }
    public void setContentsOfChest(ContentsOfChest contentsOfChest) {
        this.contentsOfChest = contentsOfChest;
    }

    @Override
    public String play() {
        switch (contentsOfChest) {
            case KNIFE -> {
                if (player.getDamage() == 10) {
                    player.setDamage(20);
                }
                return "Nasel jsi nuz, damage se ti zvysil o 10";
            }
            case DAGGER ->{
                if (player.getDamage() <25) {
                    player.setDamage(25);
                }
                return "Nasel jsi dyku, damage se ti zvysil o 10";
            }
            case AXE ->{
                if (player.getDamage()<30) {
                    player.setDamage(30);
                }
                return "Nasel jsi nuz, damage se ti zvysil o 10";
            }
            case SWORD ->{
                if (player.getDamage() <35) {
                    player.setDamage(35);
                }
                return "Nasel jsi nuz, damage se ti zvysil o 10";
            }
            case COIN -> {
                player.setNumberOfCoins(player.getNumberOfCoins()+3);
                return "Nasel jsi nuz, damage se ti zvysil o 10";
            }
            case MUSHROOM ->{
                player.setNumberOfMushrooms(player.getNumberOfMushrooms()+1);
                return "Nasel jsi nuz, damage se ti zvysil o 10";
            }
            default -> {return "tohle by se nikdy nemelo stat";
            }
        }

    }
}
