package Entities;

import Others.Player;

public class Trader extends Entity{
    Player player;

    public Trader(Player p) {
        this.player = p;
    }

    @Override
    public String play() {
        return "";
    }
}
