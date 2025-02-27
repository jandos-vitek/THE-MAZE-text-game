package Entities;

import Others.Player;

public class Key extends Entity{
    private TypeOfKey typeOfKey ;
    Player player;

    public Key(TypeOfKey typeOfKey,Player p) {
        this.typeOfKey = typeOfKey;
        this.player=p;
    }
    @Override
    public String play() {
        switch (typeOfKey){
            case BLUE ->{
                 player.setHasBlueKey(true);
                return "Nasel jsi modry klic";
                }
            case PURPLE -> {
                player.setHasPurpleKey(true);
                return "Nasel jsi fialovy klic";
            }
            case GREEN -> {
                player.setHasGreenKey(true);
                return "Nasel jsi zeleny klic";
            }
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
