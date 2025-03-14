package Entities;

import Others.Player;

public class HealingWell extends Entity{
    Player player;

    public HealingWell(Player p) {
        this.player = p;
    }

    @Override
    public String play() {
        player.setHealth(100);
        return "Nasel jsi studnu uzdraveni, tvoje zivoty jsou nyni na maximu";
    }
}
