package Entities;

import Others.Player;

public class Key extends Entity{
    private TypeOfKey typeOfKey ;
    Player player;
    private boolean hasBeenFound;

    public Key(TypeOfKey typeOfKey,Player p) {
        this.typeOfKey = typeOfKey;
        this.player=p;
    }
    @Override
    public String play() {
        if (!hasBeenFound) {
            hasBeenFound=true;
            switch (typeOfKey) {
                case BLUE -> {
                    player.setHasBlueKey(true);
                    return "Nasel jsi modry klic\n─────────────────────────────";
                }
                case PURPLE -> {
                    player.setHasPurpleKey(true);
                    return "Nasel jsi fialovy klic\n─────────────────────────────";
                }
                case GREEN -> {
                    player.setHasGreenKey(true);
                    return "Nasel jsi zeleny klic\n─────────────────────────────";
                }
            }
        }else {
            return "";
        }
        return "Tohle by se nemelo stat";
    }

    public TypeOfKey getTypeOfKey() {
        return typeOfKey;
    }

    public void setTypeOfKey(TypeOfKey typeOfKey) {
        this.typeOfKey = typeOfKey;
    }
}
