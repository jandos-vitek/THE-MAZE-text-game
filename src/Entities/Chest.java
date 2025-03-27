package Entities;

import Others.Player;

public class Chest extends Entity {
    Player player;
    private ContentsOfChest contentsOfChest;
    private boolean isEmpty;

    public Chest(ContentsOfChest contentsOfChest, Player p) {
        this.contentsOfChest = contentsOfChest;
        this.player=p;
        isEmpty=false;
    }
    public void setContentsOfChest(ContentsOfChest contentsOfChest) {
        this.contentsOfChest = contentsOfChest;
    }

    @Override
    public String play() {
        if (!isEmpty) {
            isEmpty=true;
            switch (contentsOfChest) {
                case KNIFE -> {
                    if (player.getDamage() == 10) {
                        player.setDamage(20);
                    }
                    return "Nasel jsi nuz, damage se ti zvysil na 20";
                }
                case DAGGER -> {
                    if (player.getDamage() < 20) {
                        player.setDamage(25);
                    }
                    return "Nasel jsi dyku, damage se ti zvysil na 25";
                }
                case AXE -> {
                    if (player.getDamage() < 30) {
                        player.setDamage(30);
                    }
                    return "Nasel jsi sekeru, damage se ti zvysil na 30";
                }
                case SWORD -> {
                    if (player.getDamage() < 35) {
                        player.setDamage(35);
                    }
                    return "Nasel jsi mec, damage se ti zvysil na 35";
                }
                case COIN -> {
                    player.setNumberOfCoins(player.getNumberOfCoins() + 3);
                    return "Nasel jsi 3 coiny";
                }
                case MUSHROOM -> {
                    player.setNumberOfMushrooms(player.getNumberOfMushrooms() + 1);
                    return "Nasel jsi magickou houbu";
                }
                default -> {
                    return "tohle by se nikdy nemelo stat";
                }
            }

        }
        return "Tato truhla je prazdna";
    }
}
